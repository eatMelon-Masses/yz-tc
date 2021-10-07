FROM adoptopenjdk/openjdk11

EXPOSE 8080

WORKDIR /app
COPY start/target/*.jar app.jar
CMD ["java","-jar","app.jar"]