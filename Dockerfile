FROM openjdk:8
MAINTAINER Gilles Bourquard <gbourquard63@gmail.com>
ADD target/todolist-1.0-SNAPSHOT.jar /todo/todolist-1.0-SNAPSHOT.jar
CMD ["java","-jar","/todo/todolist-1.0-SNAPSHOT.jar","server"]

