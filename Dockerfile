
FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE=target/RestApi.jar
COPY ${JAR_FILE} RestApi.jar
ENTRYPOINT ["java","-jar","/RestApi.jar"]