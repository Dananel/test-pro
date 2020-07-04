package com.txd.testjuc.mq;

import com.txd.mq.rabbitmq.RabbitMqProducer;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqTest {

    @Test
    public void testP2pModel() throws IOException, TimeoutException {
        RabbitMqProducer rabbitMqProducer = new RabbitMqProducer();
        rabbitMqProducer.p2pModel();
    }
}
