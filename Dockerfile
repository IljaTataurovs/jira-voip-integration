# Use an official Java runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/jira-voip-integration-1.0-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside the container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
