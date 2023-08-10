#FROM open-jdk:8-jre
FROM --platform=linux/amd64 openjdk:8-jre
COPY target/producer-0.0.1-SNAPSHOT.jar producer-0.0.1-SNAPSHOT-DOCKER.jar
EXPOSE 3090
ENV DBUSER_NAME = IT01
ENV PATH "$PATH:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.372.b07-4.el8.x86_64/jre/bin"
ENTRYPOINT ["java","-jar","/producer-0.0.1-SNAPSHOT-DOCKER.jar"]
