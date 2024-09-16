FROM maven:3-amazoncorretto-17-debian AS build

WORKDIR /app

COPY pom.xml ./

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests=false

FROM openjdk:17-jdk-slim

ENV DB_USERNAME=postgres
ENV DB_PASSWORD=postgres
ENV DB_HOST=db-feedback-academico
ENV DB_PORT=5432
ENV DB_NAME=feedbackAcademico
ENV JWT_SECRET=59776dc5fd37fc7dfe7dc9b7a5f43ce630a1cca058df255ff1af39232b1fe7ba

WORKDIR /app

COPY --from=build /app/target/feedback-academico-0.0.1-SNAPSHOT.jar /app/feedback-academico.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "feedback-academico.jar"]
