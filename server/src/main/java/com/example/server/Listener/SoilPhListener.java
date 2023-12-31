package com.example.server.Listener;


import com.example.model.SensorType;
import com.example.server.dao.SoilPhDao;
import com.example.server.dao.bo.SoilFc;
import com.example.server.dao.bo.SoilPh;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.time.LocalDateTime;

public class SoilPhListener {
    private SensorType sensorType;

    private String topicName;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic topic;
    private SoilPhDao soilPhDao;

    public SoilPhListener(SoilPhDao soilPhDao){
        this.sensorType = SensorType.SOILPH;
        this.topicName = sensorType.toString();
        this.soilPhDao = soilPhDao;

        //1.创建工厂连接对象，指定ip和端口号
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "failover:(tcp://localhost:61616)?Randomize=false");

        try {
            //2.创建连接和会话
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //3.创建topic对象
            topic = session.createTopic(topicName);

            //4.创建消费者
            MessageConsumer consumer = session.createConsumer(topic);

            //5、向consumer对象中设置一个messageListener对象，用来接收消息
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    // TODO Auto-generated method stub
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            double d = Double.parseDouble(textMessage.getText());
                            soilPhDao.insert(SoilPh.builder().value(d).time(LocalDateTime.now()).build());
                        } catch (JMSException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            });

//            //7.关闭资源
//            consumer.close();
//            session.close();
//            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
