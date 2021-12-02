FROM openjdk:8-jre-alpine
WORKDIR /opt/test
ARG JAR_FILE
COPY ${JAR_FILE} /opt/test/test.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","test.jar"]