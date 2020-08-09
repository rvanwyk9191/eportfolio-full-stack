FROM openjdk:8-jdk-alpine
COPY /target/eportfolio-0.0.1-SNAPSHOT.jar eportfolio.jar
ENTRYPOINT ["java","-jar","eportfolio.jar"]

