package com.iot.trying.tryingiot;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class TryingIotApplication {

	@Value("${mqtt.url}")
	private String url;

	private String clientId = UUID.randomUUID().toString();

    public static void main(String[] args) {
        SpringApplication.run(TryingIotApplication.class, args);
    }

    @Bean
    public MqttClient mqttClient() throws MqttException {
        String broker = this.url;
        MemoryPersistence persistence = new MemoryPersistence();

        return new MqttClient(broker, clientId, persistence);
    }

}
