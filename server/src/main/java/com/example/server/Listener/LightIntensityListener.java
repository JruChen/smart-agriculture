package com.example.server.Listener;


import com.example.model.SensorType;
import com.example.server.dao.LightIntensityDao;
import com.example.server.dao.WarningDao;
import com.example.server.dao.bo.LightIntensity;
import com.example.server.dao.bo.Warning;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.time.LocalDateTime;

public class LightIntensityListener {

    private SensorType sensorType;

    private String topicName;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic topic;
    private LightIntensityDao lightIntensityDao;
    private WarningDao warningDao;

    public LightIntensityListener(LightIntensityDao lightIntensityDao, WarningDao warningDao){
        this.sensorType = SensorType.LIGHTINTENSITY;
        this.topicName = sensorType.toString();
        this.lightIntensityDao = lightIntensityDao;
        this.warningDao = warningDao;

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
                            lightIntensityDao.insert(LightIntensity.builder().value(d).time(LocalDateTime.now()).build());
                            //警报范围控制
                            if(d<=45.0||d>=75.0){
                                warningDao.insert(Warning.builder().type(sensorType.toString()).value(d).time(LocalDateTime.now()).build());
                            }
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
