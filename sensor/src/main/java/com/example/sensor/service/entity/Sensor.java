package com.example.sensor.service.entity;


import com.example.model.SensorType;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public abstract class Sensor {
    private SensorType sensorType;

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic topic;
    private String topicName;
    private long intervalTime;
    private MessageProducer producer;

    public Sensor(SensorType sensorType, long intervalTime) {
        this.sensorType = sensorType;
        this.topicName = sensorType.toString();
        this.intervalTime = intervalTime;

        //1.创建工厂连接对象，指定ip和端口号
        connectionFactory = new ActiveMQConnectionFactory(
                "failover:(tcp://localhost:61616)?Randomize=false");

        try {
            //2.创建连接和会话
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //3.创建topic对象
            topic = session.createTopic(topicName);

            //4.创建生产者
            producer = session.createProducer(topic);

//            //6.关闭资源
//            producer.close();
//            session.close();
//            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendData() throws JMSException, InterruptedException {
        //5. 消息发送
        while(true){
            String d = generateData();
            TextMessage textMessage = session.createTextMessage(d);
            producer.send(textMessage);
//            System.out.println(d);
            Thread.sleep(intervalTime);
        }
        //执行3秒就退出
//        long t1 = System.currentTimeMillis();
//        while (true){
//            long t2 = System.currentTimeMillis();
//            if(t2-t1 > 30*60){
//                break;
//            }else{
//                String message = generateData();
//                TextMessage textMessage = session.createTextMessage(message);
//                producer.send(textMessage);
//                System.out.println("send: "+ topicName +" data "+ message);
//            }
//        }
    }

    public abstract String generateData();


}
