package xaut.meal.system.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.OrderSubmit;
import xaut.meal.system.pojo.Student;
import xaut.meal.system.service.ExchangeMessage;
import xaut.meal.system.service.InsertMessageService;
import xaut.meal.system.service.SearchOrderService;
import xaut.meal.system.utils.Analysis;

@Service
public class ExchangeMessageImpl implements ExchangeMessage {

    @Autowired
    private InsertMessageService insertMessageService;
    @Autowired
    private SearchOrderService searchOrderService;

    @Override
    public String sentMeaasge(String message) {

        Analysis anlysis = new Analysis();
        OrderInDB orderInDB = anlysis.AnalysisOrder(message);
        int i = orderInDB.getFood_id() / 1000 - 1;
        return RabbitMQUtil.sentMeaasge(i, message);
    }

    @Override
    public void receMessage(int food_id) {
        
        int i = food_id / 1000 - 1;
        String message = RabbitMQUtil.receMessage(i);
        Analysis analysis = new Analysis();
        insertMessageService.insertMessage(analysis.AnalysisOrder(message));
    }

    @Override
    public String bookMessage(HttpServletRequest request, String message) {
        
        OrderSubmit orderSubmit = new OrderSubmit();
        orderSubmit.setOrder_receive((new Date()).toString());
        String queueName = message;
        Student stu = (Student) request.getSession().getAttribute("stu");
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.lpush(queueName, stu.getStuNo());
        return "success";
    }
    
    @Override
    public String competeOrder(HttpServletRequest request,String message) {

        List<String> msgList = new ArrayList<String>();
        Student stu = (Student) request.getSession().getAttribute("stu");
        String stuNo = stu.getStuNo();
        Jedis jedis = new Jedis("127.0.0.1");
        List<String> list = jedis.lrange(message, 0, 1);
        String luckboy = list.get(0);
        if (luckboy.equals(stuNo)) {
            OrderSubmit orderSubmit = new OrderSubmit();
            orderSubmit.setOrder_id(Integer.parseInt(message));
            orderSubmit.setOrder_receive(stuNo);
            insertMessageService.updateOrder(orderSubmit);
            return "success";
        }else {
            return "error";
        }
    }
}
