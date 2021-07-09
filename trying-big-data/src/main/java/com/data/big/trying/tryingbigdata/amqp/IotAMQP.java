package com.data.big.trying.tryingbigdata.amqp;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import com.data.big.trying.tryingbigdata.repository.IotRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IotAMQP {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IotRepository repository;

    @Value("${rabbitmq.queue-name}")
    private String queueName;

    public void send(IotDevice iotDevice) {
        rabbitTemplate.convertAndSend(queueName, iotDevice);
    }

    @RabbitListener(queues = "${rabbitmq.queue-name}")
    public void listen(IotDevice iotDevice) throws Exception {
        repository.save(iotDevice);
    }

}
