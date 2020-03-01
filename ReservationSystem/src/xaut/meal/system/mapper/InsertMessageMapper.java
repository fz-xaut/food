package xaut.meal.system.mapper;

import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.OrderSubmit;

public interface InsertMessageMapper {
    
    void insertMessage(OrderInDB orderInDB);
    
    void updateOrder(OrderSubmit orderSubmit);

}
