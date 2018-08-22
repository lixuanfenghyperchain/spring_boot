/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Receiver
 * Author:   lixuanfeng
 * Date:     2018/7/27 下午8:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/27
 * @since 1.0.0
 */
public class Receiver {


    public static void main(String[] argv) throws Exception {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.225.138");
            factory.setPort(5672);
            factory.setUsername("test");
            factory.setPassword("123456");
            factory.setVirtualHost("testV");
            connection = factory.newConnection();
            channel = connection.createChannel();
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" Consumer have received '" + message + "'");
                }
            };
            channel.basicConsume("firstQueue", true, consumer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
