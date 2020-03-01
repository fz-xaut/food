package xaut.meal.system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import xaut.meal.system.service.JedisUtil;
import xaut.meal.system.utils.SerializeUtil;

@Component
public class JedisUtilImpl implements JedisUtil{

  
    @Autowired
    private JedisPool jedisPool;

   //���뻺��
    public void putObject(Object key, Object value) {
        
        Jedis resource = jedisPool.getResource();
        resource.set(SerializeUtil.serialize(key.toString()),SerializeUtil.serialize(value));
        resource.close();
    }
   //�������
    public Object removeObject(Object arg0) {
        
        Jedis resource = jedisPool.getResource();
        Object expire = resource.expire(SerializeUtil.serialize(arg0.toString()), 0);
        resource.close();
        return expire;
    }
    //�ӻ�����ȡ
    public Object getObject(Object arg0) {
        
        Jedis resource = jedisPool.getResource();
        Object value = SerializeUtil.unserialize(resource.get(SerializeUtil.serialize(arg0.toString())));
        resource.close();
        return value;
    }
}
