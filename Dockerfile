FROM azul/zulu-openjdk-alpine:8
USER root
ADD target/microservice-jee8-microbundle.jar target/microservice-jee8.war
EXPOSE 8080
ENTRYPOINT java -jar backend.jar
