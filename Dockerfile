FROM openjdk:21-oracle

COPY target/task_manager-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]