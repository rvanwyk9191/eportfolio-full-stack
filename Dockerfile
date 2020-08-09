FROM openjdk:8-jdk-alpine
COPY /target/eportfolio*-SNAPSHOT.jar /eportfolio.jar
ENTRYPOINT ["java","-jar","eportfolio.jar"]

