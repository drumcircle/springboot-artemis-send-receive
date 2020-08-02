package com.drumcircle.mqlogger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 7/31/20.
 */
@Configuration
@EnableJms
@EnableScheduling
public class AppConfig {

    // various @Bean definitions


}