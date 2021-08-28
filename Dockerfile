FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/wps-cac-api.jar
ENV WPTCAC_DATABASE_IP
ENV WPTCAC_DATABASE_PORT
ENV WPTCAC_DATABASE_USER
ENV WPTCAC_DATABASE_PASSWORD
COPY ${JAR_FILE} app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
EXPOSE 8888