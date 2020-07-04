package com.txd.mq.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.txd.mq.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq测试
 */
public class RabbitMqProducer {

    /**
     * 点对点模式
     */
    public void p2pModel() throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection("192.168.41.129", 5672, "test", "test", "testVitual");
        Channel channel = connection.createChannel();
        // 绑定队列,参数b：是否持久化，参数b1：是否独占，b2：消费完成是否删除
        channel.queueDeclare("hello", false, false, true, null);

        // 参数s：交换机,s1:队列
        channel.basicPublish("","hello",null,"hello".getBytes());
    }
}
