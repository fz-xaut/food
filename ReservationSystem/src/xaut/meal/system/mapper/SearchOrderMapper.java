package xaut.meal.system.mapper;

import java.util.List;

import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.OrderOutDB;
import xaut.meal.system.pojo.food;

public interface SearchOrderMapper {
    
    List<OrderOutDB> getOrderNotReceive(OrderOutDB or);
    
    Integer getCountOrder(OrderOutDB or);
    
    List<OrderOutDB> getOrderReceive(String name);
    
    String getOrderIsNotAlive(String order_id);
    
    List<MyOrder> getOrderByReceive(String receive);

    int consealOrder(String orderId);
}
