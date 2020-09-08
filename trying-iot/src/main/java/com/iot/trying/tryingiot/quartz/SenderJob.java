package com.iot.trying.tryingiot.quartz;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Component
public class SenderJob {

    @Autowired
    private MqttClient mqttClient;

    @Value("${mqtt.topic}")
    private String topic;

    @Value("${mqtt.qos}")
    private Integer qos;

    @Scheduled(fixedDelayString = "${delay-in-milliseconds}")
    public void execute() {
        String content = "{ \"userId\": \"#userId#\", \"temperature\": #temperature#, \"createdAt\": #createdAt# }";
        content = content.replace("#temperature#", String.valueOf(getRandomIntegerBetweenRange(30, 40)));
        content = content.replace("#userId#", mqttClient.getClientId());
        content = content.replace("#createdAt#", String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()));

        try {
            connect();
            publishMessage(topic, content, qos);
            disconnect();
        } catch (MqttException me) {
            log.error(me.getMessage(), me);
        }
    }

    private int getRandomIntegerBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

    private void connect() throws MqttException {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        log.info("Connecting to broker: " + mqttClient.getServerURI());
        mqttClient.connect(connOpts);
        log.info("Connected");
    }

    private void publishMessage(String topic, String content, int qos) throws MqttException {
        log.info("Publishing message: " + content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        mqttClient.publish(topic, message);
        log.info("Message published");
    }

    private void disconnect() throws MqttException {
        log.info("Disconnecting");
        mqttClient.disconnect();
        log.info("Disconnected");
    }

}
