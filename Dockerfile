
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:11-alpine
MAINTAINER github/arthurperacolli
COPY ./target/MANOJava-1.0-jar-with-dependencies.jar /app/MANOJava-1.0-jar-with-dependencies.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "MANOJava-1.0-jar-with-dependencies.jar"]
expose 8080

CMD ["/bin/sh"]
