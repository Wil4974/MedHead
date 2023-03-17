FROM openjdk:17
COPY ./target/classes/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","poc.App"]