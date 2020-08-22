FROM openjdk:8-jdk-alpine
RUN mkdir /documents
COPY /target/classes/static/documents/Reinhardt_Resume.pdf /documents/Reinhardt_Resume.pdf
COPY /target/eportfolio*-SNAPSHOT.jar /eportfolio.jar
ENTRYPOINT ["java","-jar","eportfolio.jar"]

