package xaut.meal.system.mapper;

import java.util.List;

import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.QueryVo;
import xaut.meal.system.pojo.food;

public interface SearchFoodMapper {

	List<food> getAllFood(QueryVo vo);

	Integer getCountByQueryVo(QueryVo vo);
	
	List<String> getWindow(QueryVo vo);
    
    List<String> getTaste(QueryVo vo);
    
    List<String> getPrice(QueryVo vo);
    
    List<MyOrder> getOrderByUser(String user);
    
    void confirmOrder(String orderId);
    
    int consealFood(String orderId);

}