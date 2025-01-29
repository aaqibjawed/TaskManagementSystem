# Use an official OpenJDK runtime as the base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Make gradlew executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build && ls -l build/libs

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "build/libs/TaskManagementSystem-0.0.1-SNAPSHOT.jar"]