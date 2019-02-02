FROM openjdk:8
ADD build/libs/um-spring-boot-docker-0.1.0.jar um-spring-boot-docker-0.1.0.jar
EXPOSE 7050
ENTRYPOINT ["java", "-jar", "um-spring-boot-docker-0.1.0.jar"]