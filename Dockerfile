FROM openjdk:17
COPY /target/jenkins-docker.jar jenkins-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jenkins-docker.jar"]