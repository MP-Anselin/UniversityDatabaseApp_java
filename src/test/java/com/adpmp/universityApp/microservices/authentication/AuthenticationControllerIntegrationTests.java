package com.adpmp.universityApp.microservices.authentication;

import com.adpmp.universityApp.microservices.authentication.configuration.AuthenticationConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@SpringBootTest(classes = AuthenticationConfiguration.class, properties = { "eureka.client.enabled=false" })
public class AuthenticationControllerIntegrationTests extends AbstractAuthenticationControllerTests {

}
