package com.drumcircle.mqlogger.service;

import com.drumcircle.mqlogger.util.MiscUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 7/31/20.
 */

@Slf4j
@Service
public class Receiver {

    @Value("${artemis.queue}")
    final String EVENT_QUEUE="exasol-vpd-log";

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = EVENT_QUEUE)
    public void receiveMessage(String message) {
        log.info("Received string <" + message + "> time: "+ MiscUtils.nowString());
        latch.countDown();
    }

}
