# Stage 1: Build the application using Gradle
FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN ./gradlew build --no-daemon

# Stage 2: Create the image to run the application
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/your-app.jar /app/your-app.jar

EXPOSE 7070

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 CMD curl --fail http://localhost:7070/actuator/health || exit 1

CMD ["java", "-jar", "/app/your-app.jar"]