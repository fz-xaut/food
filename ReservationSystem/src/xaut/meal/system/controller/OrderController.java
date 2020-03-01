package xaut.meal.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.OrderOutDB;
import xaut.meal.system.pojo.Student;
import xaut.meal.system.service.ExchangeMessage;
import xaut.meal.system.service.SearchFoodService;
import xaut.meal.system.service.SearchOrderService;
import xaut.meal.system.utils.Page;

@Controller
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    private ExchangeMessage exchangeMessage;
    @Autowired
    private SearchOrderService searchOrderService;
    
    /*显示没有未被接单的订单*/
    @RequestMapping("list")
    public String list(Model model, OrderOutDB or, HttpServletRequest request) {
        
        Page<OrderOutDB> page = searchOrderService.getOrderNotReceive(or);
        Student stu = (Student)request.getSession().getAttribute("stu");
        System.out.println(stu.getStuNo());
        List<MyOrder> myorder = searchOrderService.getOrderByReceive(stu.getStuNo());
        model.addAttribute("myorder",myorder);
        model.addAttribute("page", page);
        return "/WEB-INF/jsp/orderlist.jsp";
    }
    
    /*接单*/
    @RequestMapping("book")
    @ResponseBody
    public String book(HttpServletRequest request,@RequestBody String message) {

        String result = exchangeMessage.bookMessage(request, message);
        result = exchangeMessage.competeOrder(request, message);
        return result;
    }
    
    @RequestMapping("conseal")
    @ResponseBody
    public String conseal(@RequestBody String orderId) {
        
        System.err.println("取消的订单号是"+orderId);
        int result = searchOrderService.consealOrder(orderId);
        if (result == 1) {
            return "success";
        }else {
            return "error";
        }
        
    }
    
}