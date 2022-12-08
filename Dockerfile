FROM openjdk:11
VOLUME /tmp
ADD ./target/bootcoinpurse-service-0.0.1-SNAPSHOT.jar bootcoinpurse.jar
ENTRYPOINT ["java","-jar","bootcoinpurse.jar"]