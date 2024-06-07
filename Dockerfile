FROM openjdk:17-jdk

ENV APP_HOME=/usr/app

WORKDIR ${APP_HOME}

COPY build/libs/*.jar crud-restapi-challenge-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "crud-restapi-challenge-0.0.1-SNAPSHOT.jar"]