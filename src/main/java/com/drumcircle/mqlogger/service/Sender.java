package com.drumcircle.mqlogger.service;

import com.drumcircle.mqlogger.util.MiscUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 7/31/20.
 */

@Slf4j
@Service
public class Sender {

    @Value("${artemis.queue}")
    final String EVENT_QUEUE="exasol-vpd-log";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message) {
        log.info("sending message='{}', time: {}", message, MiscUtils.nowString());
        jmsTemplate.convertAndSend(EVENT_QUEUE, message);
    }

}
