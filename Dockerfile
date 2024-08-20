FROM eclipse-temurin:17-noble
WORKDIR demo

COPY target/*.jar vk-ping-pong.jar
COPY target/classes/application.properties application.properties
ENTRYPOINT ["java", "-jar", "vk-ping-pong.jar"]