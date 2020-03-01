package xaut.meal.system.service;

import javax.servlet.http.HttpServletRequest;

import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.OrderSubmit;

public interface ExchangeMessage {
    
    void receMessage(int food_id);

    String sentMeaasge(String message);
    
    String bookMessage(HttpServletRequest request,String message);
    
    String competeOrder(HttpServletRequest request,String message);

}
