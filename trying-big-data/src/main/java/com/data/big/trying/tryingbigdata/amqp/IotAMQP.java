package com.data.big.trying.tryingbigdata.amqp;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class IotAMQP {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TemperatureRepository repository;

    @Value("${rabbitmq.queue-name}")
    private String queueName;

    public void send(Temperature temperature) {
        rabbitTemplate.convertAndSend(queueName, temperature);
    }

    @RabbitListener(queues = "${rabbitmq.queue-name}")
    public void listen(Temperature temperature) throws Exception {
        repository.save(temperature);
    }

}
