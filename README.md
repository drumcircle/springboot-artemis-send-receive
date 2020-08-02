# ActiveMQ Artemis remote logger

The purpose of this project is to provide real-time, remote logging from distributed or containerized apps using ActiveMQ.

## History

Initiali release, August 2, 2020

## Customizing

Customize the logging behaviro by editinging the Receiver.java

    com.drumcircle.mqlogger.service.Receiver
    
## Getting started
This project runs ArtemisMQ in either embedded or local mode using docker-compose.

Use the "embedded" profile for the embedded service.

Use the "local" profile to read and write to the local MQ.

To run local ArtemisMQ, edit the configuration parameters in docker-compose.yml and run:

    docker-compose up
    
From the local project root directory.

Shout out to Victor Romero for the Artemis dockerfile.

## Testing

The application starts on 8082 by default and exposes a testing endpoint:

      @RequestMapping(value = "/logging/send", method = RequestMethod.POST)