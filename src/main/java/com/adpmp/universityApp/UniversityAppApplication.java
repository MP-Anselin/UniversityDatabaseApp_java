package com.adpmp.universityApp;

import com.adpmp.universityApp.microservices.managers.server.ManagersServer;
import com.adpmp.universityApp.microservices.registration.server.RegistrationServer;
import com.adpmp.universityApp.microservices.students.server.StudentsServer;
import com.adpmp.universityApp.microservices.teachers.server.TeachersServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class UniversityAppApplication {

    public static final String NO_VALUE = "NO-VALUE";

    public static void main(String[] args) {
        String serverName = NO_VALUE;
        String port = null;

        System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        for (String arg : args) {
            if (arg.startsWith("--"))
                continue;
            if (serverName.equals(NO_VALUE))
                serverName = arg;
            else if (port == null)
                port = arg;
            else {
                System.out.println("Unexpected argument: " + arg);
                usage();
                return;
            }
        }

        if (serverName.equals(NO_VALUE)) {
            usage();
            return;
        }

        if (port != null)
            System.setProperty("server.port", port);

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Running on IP: " + inetAddress.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (serverName) {
            case "registration":
                System.out.println("start registration");
                RegistrationServer.main(args);
                break;
            case "manager":
                System.out.println("start manager");
                ManagersServer.main(args);
                break;
            case "teacher":
                System.out.println("start teacher");
                TeachersServer.main(args);
                break;
            case "student":
                StudentsServer.main(args);
                System.out.println("start student");
                break;
            default:
                System.out.println("Unknown server type: " + serverName);
                usage();
                break;
        }
    }

    protected static void usage() {
        System.out.println();
        System.out.println("Usage: java -jar ... <server-name> [server-port]");
        System.out.println("     where");
        System.out.println("       server-name is 'reg', 'university', " + "teacher' or 'student'");
        System.out.println("       server-port > 1024");
        System.out.println();
    }

}
