FROM openjdk:8-jre
EXPOSE 3091
COPY target/consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT-DOCKER.jar
ENV DBUSER_NAME = IT01
ENTRYPOINT ["java","-jar","/consumer-0.0.1-SNAPSHOT-DOCKER.jar"]
