# Run Using Docker

## Build the Image

1. Fetch the code using git clone `https://github.com/MP-Anselin/UniversityDatabaseApp_java`

1. Build using either `mvn clean package`

   This will create the jar: `target/universityApp-0.0.1-SNAPSHOT.jar`

1. Here is the Dockerfile:

    ```sh
    FROM openjdk:11-jre
    ADD target/universityApp-0.0.1-SNAPSHOT.jar app.jar
    EXPOSE 1111
    EXPOSE 2222
    EXPOSE 3333
    EXPOSE 4444
    EXPOSE 5555
    EXPOSE 6666
    ```

   What this does:

    * Use the OpenJDK 11 docker image (freely available at Docker hub) as a starting point. This image defines a minimal Linux system with OpenJDK 8 preinstalled.
    * Copy the demo jar into the container and rename it to `app.jar` to save typing later.  By default, `app.jar` will be copied into the root of the container file system.
    * Expose ports 1111, 2222, 3333, 4444, 5555 and 6666.

1. To build the container (**note** the `.` at the end, indicating to use the current directory as its working directory):

    ```sh
    docker build -t university/microservices .
    ```

1. Check it worked. You should see `university/microservices` listed.

    ```sh
    docker images
    ```

## Running the Application

We will run the container three times, each time running the Java application in a different mode.

1. They need to talk to each other, so let's give them a network:

    ```sh
    docker network create university-net
    ```

1. Now run the first container. This runs up the Eureka registration server, which will allow the other microservices to find each other:
   
    ```sh
    docker run --name reggo --hostname reggo --network university-net -p 1111:1111 university/microservices java -jar app.jar reg
    ```

   The `-d` (detach) flag is missing so all output will stream to the console so we can see what is happening.

   As soon as the application starts up, it displays its IP address. Remember this for later.

1. In your browser, go to http://localhost:1111 and you should see the Eureka dashboard. There are no instances registered.

1. _In a new CMD/Terminal window_, run a second container for the authentication microservice

    ```sh
    docker run --name authentication --hostname authentication --network university-net -p 2222:2222 university/microservices java -jar app.jar authentication  --registration.server.hostname=<reg server ip addr>
    ```

   Replace `<eg server ip addr>` with the IP address you determined earlier.

1. Return to the Eureka Dashboard in your browser and refresh the screen.  You should see that `AUTHENTICATION-SERVICE` is now registered.

1. _In a new CMD/Terminal window_, run a third container for the administrator web-service. This is a web-application for viewing administrators information by requesting administrator data from the administrators and authentication microservice.

    ```sh
    docker run --name administrator --hostname administrator --network university-net -p 3333:3333 university/microservices java -jar app.jar administrator --registration.server.hostname=<eg server ip addr>
    ```

   Replace `<eg server ip addr>` with the IP address you determined earlier.
1. _In a new CMD/Terminal window_, run a third container for the teacher web-service. This is a web-application for viewing administrators information by requesting teachers data from the teacher and authentication microservice.

    ```sh
    docker run --name teacher --hostname teacher --network university-net -p 4444:4444 university/microservices java -jar app.jar teacher --registration.server.hostname=<eg server ip addr>
    ```

   Replace `<eg server ip addr>` with the IP address you determined earlier.
1. _In a new CMD/Terminal window_, run a fourth container for the student web-service. This is a web-application for viewing students information by requesting students data from the student and authentication microservice.

    ```sh
    docker run --name student --hostname student --network university-net -p 5555:5555 university/microservices java -jar app.jar student --registration.server.hostname=<eg server ip addr>
    ```

   Replace `<eg server ip addr>` with the IP address you determined earlier.
1. _In a new CMD/Terminal window_, run a fifth container for the university web-service. This is a web-application for viewing accounts teacher and student information by requesting account data from the accounts teacher and student  microservice.

    ```sh
    docker run --name web --hostname web --network university-net -p 6666:6666 university/microservices java -jar app.jar web --registration.server.hostname=<eg server ip addr>
    ```

   Replace `<eg server ip addr>` with the IP address you determined earlier.

1. Return to the Eureka Dashboard in your browser and refresh the screen.  You should see that `ADMINISTRATOR-SERVICE`, `TEACHER-SERVICE`, `STUDENTS-SERVICE` and `UNIVERSITY-SERVICE` are now registered.

1. In a second browser tab, go to http://localhost:6666.  This is the web interface you just deployed and you should be able to view, list and search for account information.
