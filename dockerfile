FROM openjdk:latest

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . /app

CMD ["mvn", "clean", "package"]
