# Use a base image with JDK installed
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/myapp.jar /app/app.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the Java application
CMD ["java", "-jar", "app.jar"]
