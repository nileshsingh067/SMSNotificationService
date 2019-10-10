FROM openjdk:8
MAINTAINER Nilesh Singh,Sonveer Tomer
ADD target/SMSNotificationService-0.0.1-SNAPSHOT.jar SMSNotificationService-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","SMSNotificationService-0.0.1-SNAPSHOT.jar"]
