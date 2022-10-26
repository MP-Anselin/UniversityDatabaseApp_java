# university-microservices

## Versions


## Using an IDE

You can run the system in your IDE by running the three server classes in order: _RegistrationService_, _AccountsService_ and _WebService_.  Each is a Spring Boot application using embedded Tomcat.  If using Spring Tools use `Run As ... Spring Boot App` otherwise just run each as a Java application - each has a static `main()` entry point.

As discussed in the Blog, open the Eureka dashboard [http://localhost:1111](http://localhost:1111) in your browser to see that the `AUTHENTIFICATION-SERVICE`, `TEACHER-SERVICE`, `STUDENTS-SERVICE` and `UNIVERSITY-SERVICE` applications have registered.  Next open the Demo Home Page [http://localhost:1111](http://localhost:1111) in and click one of the demo links.

The `localhost:6666` web-site is being handled by a Spring MVC Controller in the _UniversityService_ application, but you should also see logging output from _Authentication_ showing requests for Account data.

## Command Line

You may find it easier to view the different applications by running them from a command line since you can place the three windows side-by-side and watch their log output

For convenience we are building a 'fat' executble jar whose start-class (main method entry-point) is defined to be in the class `io.pivotal.microservices.services.Main`.  This application expects a single command-line argument that tells it to run as any of our three servers.

```
java -jar target/universityApp-0.0.1-SNAPSHOT.jar registration|authentification|teacher|student|university
```

### Procedure

To run the microservices system from the command-line, open three CMD windows (Windows) or three Terminal windows (MacOS, Linux) and arrange so you can view them conveniently.

 1. In each window, change to the directory where you cloned the demo.
 1. In the first window, build the application using either `./mvnw clean package`.  Either way the
    generated file will be `target/universityApp-0.0.1-SNAPSHOT.jar` (even if you used gradle).
 1. In the same window run: `java -jar target/universityApp-0.0.1-SNAPSHOT.jar registration`
 1. Switch to the second window and run: `java -jar target/universityApp-0.0.1-SNAPSHOT.jar authentification`
 1. Switch to the third window and run: `java -jar target/universityApp-0.0.1-SNAPSHOT.jar director`
 1. Switch to the fourth window and run: `java -jar target/universityApp-0.0.1-SNAPSHOT.jar profiles`
 1. Switch to the sixth window and run: `java -jar target/universityApp-0.0.1-SNAPSHOT.jar university`
 1. In your favorite browser open the same two links: [http://localhost:1111](http://localhost:1111) and you can do your request with the url [http://localhost:6666](http://localhost:6666)

You should see servers being registered in the log output of the first (registration) window.
As you interact wiht the Web application, you should logging in the both the second and third windows...

For a list of valid accounts refer to the [data.sql](https://github.com/MP-Anselin/UniversityDatabaseApp_java/blob/main/src/main/resources/database/scripts/data-h2.sql) that is used by the Account Service to set them up.

 1. In a new window, run up a second account-server using HTTP port 2223:
     * `java -jar target/universityApp-0.0.1-SNAPSHOT.jar authentification 2223`
 1. Allow it to register itself
 1. Kill the first authentication-server and see the university-server switch to using the new authentication-server - no loss of service.

## Using Docker

This application can also be run using 3 docker containers. See [here](use-docker.md).

