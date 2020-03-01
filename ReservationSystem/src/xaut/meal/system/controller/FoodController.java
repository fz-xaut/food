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
import xaut.meal.system.pojo.QueryVo;
import xaut.meal.system.pojo.Student;
import xaut.meal.system.pojo.food;
import xaut.meal.system.service.ExchangeMessage;
import xaut.meal.system.service.SearchFoodService;
import xaut.meal.system.utils.Page;

@Controller
@RequestMapping("food")
public class FoodController {

    @Autowired
    private SearchFoodService searchFoodService;
   // private NavigationService navigationService;
    @Autowired
    private ExchangeMessage exchangeMessage;

    /*加载上方选择框中信息*/
    @RequestMapping("list")
    public String list(Model model, QueryVo vo, HttpServletRequest request) {

        Page<food> page = searchFoodService.getFoodByQueryVo(vo);
        Student stu = (Student)request.getSession().getAttribute("stu");
        System.out.println(stu.getStuNo());
        List<MyOrder> myorder = searchFoodService.getOrderByUser(stu.getStuNo());
        List<String> window = searchFoodService.getWindow(vo);
        List<String> taste = searchFoodService.getTaste(vo);
        List<String> price = searchFoodService.getPrice(vo);
        model.addAttribute("page", page);
        model.addAttribute("myorder",myorder);
        model.addAttribute("window", window);
        model.addAttribute("taste", taste);
        model.addAttribute("price", price);
        return "/WEB-INF/jsp/foodList.jsp";
    }

    /*订餐，放入消息队列中*/
    @RequestMapping("book")
    @ResponseBody
    public String book(@RequestBody String message) {

        String result = exchangeMessage.sentMeaasge(message);
        return result;
    }
    
    /*提交订餐信息，入库*/
    @RequestMapping("submit")
    public void submit(Model model, int food_id) {
        
        exchangeMessage.receMessage(food_id);
    }
    
    @RequestMapping("confirm")
    @ResponseBody
    public String confirm(@RequestBody String orderId) {
        
        try{
            searchFoodService.confirmOrder(orderId);
        }catch(Exception e) {
            return "error";
        }
        return "success";
        
    }
    
    @RequestMapping("conseal")
    @ResponseBody
    public String conseal(@RequestBody String orderId) {
        
        int result = searchFoodService.consealFood(orderId);
        if (result == 1) {
            return "success";
        }else {
            return "error";
        }
        
    }
    
}
