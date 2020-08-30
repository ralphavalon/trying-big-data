package com.iot.trying.tryingiot.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderJob {

    @Scheduled(fixedDelayString = "${delay-in-milliseconds}")
    public void execute() {
        log.info("Running");
    }
}
