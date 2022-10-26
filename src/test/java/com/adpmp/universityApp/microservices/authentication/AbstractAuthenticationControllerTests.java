package com.adpmp.universityApp.microservices.authentication;

import com.adpmp.universityApp.microservices.authentication.components.controller.AuthenticationController;
import com.adpmp.universityApp.microservices.authentication.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.authentication.components.model.Accounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.logging.Logger;

//@TestPropertySource(locations = "classpath:authentication-controller-tests.properties")

@TestPropertySource(properties={"eureka.client.enabled=false"})
public abstract class AbstractAuthenticationControllerTests {

	@Autowired
	AuthenticationController authenticationController;

	@Test
	public void validLogin() {
		Logger.getGlobal().info("Start validLogin test");

		RegistrationDto params = new RegistrationDto();
		params.setDnie("MPadp666-C");
		params.setFirstName("MP");
		params.setLastName("MP");
		Accounts userLog = authenticationController.login(params).getBody();

		Assertions.assertNotNull(userLog);
		Assertions.assertEquals(true, userLog.getIs_log());
		Assertions.assertEquals(params.getFirstName(), userLog.getFirst_name());
		Logger.getGlobal().info("End validLogin test");
	}

	@Test
	public void validRegistration() {
		Logger.getGlobal().info("Start validRegistration test");

		RegistrationDto params = new RegistrationDto();
		params.setDnie("MPadp666-A");
		params.setFirstName("MP-test");
		params.setLastName("MP-test");
		params.setUserRoleId(1);
		Accounts userLog = authenticationController.registration(params).getBody();

		Assertions.assertNotNull(userLog);
		Assertions.assertEquals(params.getFirstName(), userLog.getFirst_name());
		Assertions.assertEquals(params.getLastName(), userLog.getLast_name());
		Logger.getGlobal().info("End validRegistration test");
	}
}
