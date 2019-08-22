FROM openjdk:11-slim

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]