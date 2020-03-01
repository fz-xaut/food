
package xaut.meal.system.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaut.meal.system.mapper.SearchFoodMapper;
import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.QueryVo;
import xaut.meal.system.pojo.food;
import xaut.meal.system.service.JedisUtil;
import xaut.meal.system.service.SearchFoodService;
import xaut.meal.system.utils.Page;
import xaut.meal.system.utils.SerializeUtil;

@Service
public class SearchFoodServiceImpl implements SearchFoodService {

    @Autowired
    private SearchFoodMapper searchFoodMapper;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public Page<food> getFoodByQueryVo(QueryVo vo) {
        
        vo.setStart((vo.getPage() - 1) * vo.getRows());
        List<food> foods = new ArrayList<food>();
        List<food> cachefoods = null;
        System.err.println("foods"+vo.getfId()+vo.getfWindow()+vo.getfTaste()+vo.getfPrice());
        Object Redisfoods = jedisUtil.getObject("foods"+vo.getfId()+vo.getfWindow()+vo.getfTaste()+vo.getfPrice());
        if (Redisfoods!=null) {
            cachefoods = (List<food>)SerializeUtil.unserialize((byte[])Redisfoods);
        }else {
            cachefoods = searchFoodMapper.getAllFood(vo);
            jedisUtil.putObject("foods"+vo.getfId()+vo.getfWindow()+vo.getfTaste()+vo.getfPrice(),SerializeUtil.serialize(cachefoods));
        }
        for (int i = vo.getStart();i < vo.getStart()+10 && i< cachefoods.size(); i++) {
            foods.add(cachefoods.get(i));
        }
        /*
         * vo.setStart((vo.getPage() - 1) * vo.getRows()); // 查询总记录数 Integer total =
         * searchFoodMapper.getCountByQueryVo(vo); // 查询每页的数据列表 List<food> list =
         * searchFoodMapper.getAllFood(vo);
         */
        Page<food> page = new Page<food>(cachefoods.size(), vo.getPage(), vo.getRows(), foods);
        return page;
    }
    
    
    @Override
    public List<MyOrder> getOrderByUser(String user) {
        
        return searchFoodMapper.getOrderByUser(user);
    }

    public List<String> getWindow(QueryVo vo) {

        List<String> window = null;
        Object Rediswindow = jedisUtil.getObject("window"+vo.getfWindow());
        if (Rediswindow!=null) {
            window = (List<String>)SerializeUtil.unserialize((byte[])Rediswindow);
            System.err.println("查询了缓存window");
        }else {
            window = searchFoodMapper.getWindow(vo);
            System.err.println("查询了数据库window");
            jedisUtil.putObject("window"+vo.getfWindow(),SerializeUtil.serialize(window));
        }
        return window;
    }

    @Override
    public List<String> getTaste(QueryVo vo) {
        
        List<String> taste = null;
        Object Redistaste = jedisUtil.getObject("taste"+vo.getfTaste());
        if (Redistaste!=null) {
            taste = (List<String>)SerializeUtil.unserialize((byte[])Redistaste);
            System.err.println("查询了缓存taste");
        }else {
            taste = searchFoodMapper.getTaste(vo);
            jedisUtil.putObject("taste"+vo.getfTaste(),SerializeUtil.serialize(taste));
        }
        return taste;
    }

    @Override
    public List<String> getPrice(QueryVo vo) {
        
        List<String> price = null;
        Object Redisprice = jedisUtil.getObject("price"+vo.getfPrice());
        if (Redisprice!=null) {
            price = (List<String>)SerializeUtil.unserialize((byte[])Redisprice);
            System.err.println("查询了缓存price");
        }else {
            price = searchFoodMapper.getPrice(vo);
            jedisUtil.putObject("price"+vo.getfPrice(),SerializeUtil.serialize(price));
        }
        return price;
    }


    @Override
    public void confirmOrder(String orderId) {
        
        searchFoodMapper.confirmOrder(orderId);
    }


    @Override
    public int  consealFood(String orderId) {
        
        return searchFoodMapper.consealFood(orderId);
    }

}
