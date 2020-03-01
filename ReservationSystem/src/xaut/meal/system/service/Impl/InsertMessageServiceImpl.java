package xaut.meal.system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xaut.meal.system.mapper.InsertMessageMapper;
import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.OrderSubmit;
@Service
public class InsertMessageServiceImpl implements xaut.meal.system.service.InsertMessageService {

    @Autowired
    private InsertMessageMapper insertMessageMapper;
    
    @Override
    public void insertMessage(OrderInDB orderInDB) {
        
        insertMessageMapper.insertMessage(orderInDB);

    }

    @Override
    public void updateOrder(OrderSubmit orderSubmit) {
        
        insertMessageMapper.updateOrder(orderSubmit);
        
    }

}
