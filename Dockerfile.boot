# Multi-Stage build

# Build conatiner
FROM maven:3.6.0-jdk-8 as maven-build
COPY . /opt/mqlogger/
WORKDIR /opt/mqlogger/
RUN mvn clean package

# Target container
FROM openjdk:8-jre-alpine
WORKDIR /opt/mqlogger/
COPY ./target/mqlogger.jar .

CMD [ "java", "-jar", "./mqlogger.jar" ]