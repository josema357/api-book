FROM eclipse-temurin:17-jdk-alpine
COPY build/libs/book-1.0.0.jar java-app.jar
ENTRYPOINT [ "java", "-jar", "java-app.jar" ]