FROM openjdk:11-jdk-slim
COPY target/your-app.jar your-app.jar
ENTRYPOINT ["java", "-jar", "/your-app.jar"]
