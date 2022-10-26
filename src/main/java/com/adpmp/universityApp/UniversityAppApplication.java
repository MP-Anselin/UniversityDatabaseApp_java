package com.adpmp.universityApp;

import com.adpmp.universityApp.microservices.authentication.AuthenticationServer;
import com.adpmp.universityApp.microservices.director.DirectorServer;
import com.adpmp.universityApp.microservices.profiles.ProfileServer;
import com.adpmp.universityApp.microservices.registration.RegistrationServer;
import com.adpmp.universityApp.microservices.university.UniversityServer;

import java.net.InetAddress;

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
            case "reg":
                System.out.println("start registration");
                RegistrationServer.main(args);
                break;
            case "authentication":
            case "auth":
                System.out.println("start authentication");
                AuthenticationServer.main(args);
                break;
            case "university":
                System.out.println("start university");
                UniversityServer.main(args);
                break;
            case "director":
                System.out.println("start director");
                DirectorServer.main(args);
                break;
            case "profiles":
                System.out.println("start profiles");
                ProfileServer.main(args);
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
