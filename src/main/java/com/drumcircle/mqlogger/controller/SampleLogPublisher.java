package com.drumcircle.mqlogger.controller;

import com.drumcircle.mqlogger.service.Sender;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 7/31/20.
 */


@Slf4j
@Controller
public class SampleLogPublisher {

    @Value("${artemis.queue}")
    final String EVENT_QUEUE="exasol-vpd-log";

    @Autowired
    private Sender sender;

    @ApiOperation(value = "Gets all Apis")
    @RequestMapping(value = "/logging/send", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void sendString(@RequestBody String message) {
        log.debug("Sending logger message <" + message + "> to queue <" + EVENT_QUEUE + ">");
        sender.send(message);
    }
}
