FROM openjdk:8-jdk-alpine
RUN addgroup -S wpsuser && adduser -S wpsuser -G wpsuser
USER wpsuser:wpsuser
ARG JAR_FILE=target/wps-cac-api.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080