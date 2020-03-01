package xaut.meal.system.service.Impl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;

public class RabbitMQUtil {
    
    public static String EXCHANGE_NAME = "food_order";
    public static String[] routingKeys = new String[] { "first", "second", "third", "forth" };
    public static String[] restaurants = new String[] { "first_Restaurant", "second_Restaurant", "third_Restaurant","forth_Restaurant" };
    
    
    public static Connection connect() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        };
        return connection;
    }
    
    //将前端下的订单请求发送到消息队列中
    public static String sentMeaasge(int i, String message) {
        
        Connection connection = RabbitMQUtil.connect();
        try {
            Channel channel = connection.createChannel();
            channel.queueDeclare(restaurants[i], true, false, false, null);
            channel.basicPublish(EXCHANGE_NAME, routingKeys[i], MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            return "error";
        }
        return "success";
    }
    
    //削峰的操作，取出消息队列中的值（异步调用这一方法）
    public static String receMessage(int i) {
        
        Connection connection = RabbitMQUtil.connect();
        String message = null;
        try {
            Channel channel = connection.createChannel();
            channel.queueDeclare(restaurants[i], true, false, false, null);
            DeclareOk declareOK = channel.queueDeclarePassive(restaurants[i]);
            int num = declareOK.getMessageCount();
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            channel.basicConsume(restaurants[i], true, queueingConsumer);
            if (num > 0) {
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                message = new String(delivery.getBody(), "UTF-8");
            }
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException | ShutdownSignalException | ConsumerCancelledException | InterruptedException e) {
            return message;
        }
        return message;
    }
    
}
