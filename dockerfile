FROM openjdk:11
MAINTAINER Santhakumari<Santha@gmail.com>
VOLUME /tmp
ARG JAR_FILE=target/Employee-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} loginapp.jar
ENTRYPOINT ["java", "-jar", "/loginapp.jar"]
