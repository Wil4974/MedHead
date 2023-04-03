FROM openjdk:17-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
ENV JAVA_HOME=/etc/java/java-17-openjdk

FROM postgres:latest
ENV POSTGRES_USER=wil
ENV POSTGRES_PASSWORD=wil
ENV POSTGRES_DB=medhead
COPY src/main/docker/init.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
