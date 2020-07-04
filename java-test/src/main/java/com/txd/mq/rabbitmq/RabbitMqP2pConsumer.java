package com.txd.mq.rabbitmq;

import com.rabbitmq.client.*;
import com.txd.mq.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqP2pConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection("192.168.41.129", 5672, "test", "test", "testVitual");
        Channel channel = connection.createChannel();

        // 绑定队列,参数b：是否持久化，参数b1：是否独占，b2：消费完成是否删除
        channel.queueDeclare("hello", false, false, true, null);

        // 参数：队列，是否确认，消费回调
        channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费====" + new String(body));
            }
        });
    }
}
