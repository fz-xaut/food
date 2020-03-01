package xaut.meal.system.service;

import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.OrderSubmit;

public interface InsertMessageService {
    
    void insertMessage(OrderInDB orderInDB);
    
    void updateOrder(OrderSubmit orderSubmit);

}
