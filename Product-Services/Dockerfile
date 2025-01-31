
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/Product-Services-0.0.1-SNAPSHOT.jar /app/Product-Services-0.0.1-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "Product-Services-0.0.1-SNAPSHOT.jar"]
