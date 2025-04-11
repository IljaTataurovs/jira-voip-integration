# Use a lightweight Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the packaged JAR with dependencies into the container
COPY target/jira-voip-integration-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Expose port 80 to match Azure Container Apps routing
EXPOSE 80

# Set default command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
