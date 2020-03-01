package xaut.meal.system.service;


import java.util.List;

import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.OrderOutDB;
import xaut.meal.system.utils.Page;

public interface SearchOrderService {
    
    Page<OrderOutDB> getOrderNotReceive(OrderOutDB or);
    
    boolean getOrderIsNotAlive(String order_id);
    
    List<MyOrder> getOrderByReceive(String receive);

    int consealOrder(String orderid);
}
