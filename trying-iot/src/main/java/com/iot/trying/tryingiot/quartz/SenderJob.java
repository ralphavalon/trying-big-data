package com.iot.trying.tryingiot.quartz;

import com.iot.trying.tryingiot.client.ApiClient;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderJob {

    private String clientId = UUID.randomUUID().toString();

    @Autowired
    private ApiClient apiClient;

    @Scheduled(fixedDelayString = "${delay-in-milliseconds}")
    public void execute() {
        String content = "{ \"userId\": \"#userId#\", \"temperature\": #temperature#, \"scale\": \"#scale#\", \"createdAt\": #createdAt# }";
        content = content.replace("#temperature#", String.valueOf(getRandomIntegerBetweenRange(30, 40)));
        content = content.replace("#userId#", clientId);
        content = content.replace("#scale#", "Celsius");
        content = content.replace("#createdAt#", String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()));

        log.info("Publishing message: " + content);
        apiClient.addTemperature(content);
        log.info("Message published");
    }

    private int getRandomIntegerBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

}
