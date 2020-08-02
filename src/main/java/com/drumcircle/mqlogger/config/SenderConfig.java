package com.drumcircle.mqlogger.config;


import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Profile("!embedded")
@Configuration
public class SenderConfig {
    @Value("${artemis.queue}")
    String EVENT_QUEUE="exasol-vpd-log";

    @Value("${artemis.user}")
    private String user;
    @Value("${artemis.password}")
    private String password;

    @Value("${artemis.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
        ActiveMQConnectionFactory cf= new ActiveMQConnectionFactory(brokerUrl);
        cf.setUser(user);
        cf.setPassword(password);
        return cf;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(
                senderActiveMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(cachingConnectionFactory());
    }

}