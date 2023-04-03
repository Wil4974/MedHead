FROM openjdk:17-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
ENV JAVA_HOME=/etc/java/java-17-openjdk