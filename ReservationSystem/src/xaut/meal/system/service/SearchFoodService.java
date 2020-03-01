package xaut.meal.system.service;



import java.util.List;

import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.QueryVo;
import xaut.meal.system.pojo.food;
import xaut.meal.system.utils.Page;

public interface SearchFoodService {
	
	Page<food> getFoodByQueryVo(QueryVo vo);
	
	List<MyOrder> getOrderByUser(String user);
	
	List<String> getWindow(QueryVo vo);
    
    List<String> getTaste(QueryVo vo);
    
    List<String> getPrice(QueryVo vo);
    
    void confirmOrder(String orderid);
    
    int consealFood(String orderid);
}