# Start with a base image containing Java runtime (JDK 17)
FROM openjdk:17-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

ADD target/demo*.jar my-application.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/my-application.jar"]