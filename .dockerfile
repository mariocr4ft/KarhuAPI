FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/your-artifact.jar .
CMD ["java", "-jar", "your-artifact.jar"]
