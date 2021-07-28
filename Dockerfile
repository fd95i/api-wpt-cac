FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/wps-cac-api.jar
COPY ${JAR_FILE} app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
EXPOSE 8888