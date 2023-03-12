
FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD ./target/lanchonetebasico1-0.0.1-SNAPSHOT.jar lanchonetebasico1.jar
ENTRYPOINT ["java","-jar","/lanchonetebasico1.jar"]