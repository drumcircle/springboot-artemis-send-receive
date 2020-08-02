package com.drumcircle.mqlogger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 8/1/20.
 */

@Profile("embedded")
public class EmbeddedArtemisConfig {


    @Autowired
    private ArtemisProperties artemisProperties;

    @Bean
    public ArtemisConfigurationCustomizer customizer() {
        return new ArtemisConfigurationCustomizer() {

            @Override
            public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
                try {
                    configuration.addAcceptorConfiguration("netty", "tcp://localhost:" + artemisProperties.getPort());


                    // AddressSettings
                    // This doesn't work yet and needs some fixing
					/*AddressSettings settings = new AddressSettings();
					settings.setAutoCreateJmsTopics(true);
					settings.setAutoCreateJmsQueues(true);

					SimpleString deadLetterRequest = new SimpleString("jms.queue.deadLetterQueue");
					settings.setMaxDeliveryAttempts(3);
					settings.setDeadLetterAddress(deadLetterRequest);
					settings.setExpiryAddress(deadLetterRequest);

					configuration.addAddressesSetting("settings", settings);*/

                } catch (Exception e) {
                    throw new RuntimeException("Failed to add netty transport acceptor to artemis instance", e);
                }

            }

        };
    }

}
