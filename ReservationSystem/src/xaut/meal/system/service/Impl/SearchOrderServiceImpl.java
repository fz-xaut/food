package xaut.meal.system.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xaut.meal.system.mapper.SearchOrderMapper;
import xaut.meal.system.pojo.MyOrder;
import xaut.meal.system.pojo.OrderOutDB;
import xaut.meal.system.service.SearchOrderService;
import xaut.meal.system.utils.Page;
@Service
public class SearchOrderServiceImpl implements SearchOrderService {
    
    
    @Autowired
    private SearchOrderMapper searchOrderMapper;

    @Override
    public Page<OrderOutDB> getOrderNotReceive(OrderOutDB or) {
   
      //�����ҳ��ѯ��������¼��ʼ
        or.setStart((or.getPage() - 1) * or.getRows());
        
        //��ѯ�ܼ�¼��
        Integer total = searchOrderMapper.getCountOrder(or);
        
        //��ѯÿҳ�������б�
        List<OrderOutDB> list = searchOrderMapper.getOrderNotReceive(or);
        
        //��װ��ҳ����
        Page<OrderOutDB> page = new Page<OrderOutDB>(total, or.getPage(), or.getRows(), list);
        
        return page;
    }

    @Override
    public boolean getOrderIsNotAlive(String order_id) {
        try {
            String result = searchOrderMapper.getOrderIsNotAlive(order_id);
            if (result == null) {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<MyOrder> getOrderByReceive(String receive) {
        
        return searchOrderMapper.getOrderByReceive(receive);
        
    }

    @Override
    public int consealOrder(String orderid) {
        
        return searchOrderMapper.consealOrder(orderid);
    }
    
    
}
