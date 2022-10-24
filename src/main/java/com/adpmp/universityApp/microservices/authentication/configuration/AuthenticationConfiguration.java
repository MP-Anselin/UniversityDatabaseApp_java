package com.adpmp.universityApp.microservices.authentication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@PropertySource("classpath:database/db-config.properties")
public class AuthenticationConfiguration {

	protected Logger logger;

	@Autowired
	private Environment env;

	public AuthenticationConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driverClassName")));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));

		// schema init
		Resource initSchema = new ClassPathResource(Objects.requireNonNull(env.getProperty("spring.datasource.path.schema-h2")));
		Resource initData = new ClassPathResource(Objects.requireNonNull(env.getProperty("spring.datasource.path.data-h2")));
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return dataSource;
	}
}
