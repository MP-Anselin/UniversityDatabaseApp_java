FROM openjdk:11-jre
ADD target/microservices-demo-2.0.0.RELEASE.jar app.jar
EXPOSE 1111
EXPOSE 2222
EXPOSE 3333
EXPOSE 4444
EXPOSE 5555
EXPOSE 6666
# Optional default command
# ENTRYPOINT ["java","-jar","/app.jar","reg"]

