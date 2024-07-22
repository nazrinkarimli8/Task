FROM openjdk:22
COPY target/ReservationApp-1.0-SNAPSHOT.jar task.jar
ENTRYPOINT ["java", "-jar", "task.jar"]