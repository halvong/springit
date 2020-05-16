package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.SpringProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
		    log.error("error");
			log.warn("warn");
			log.info("info");
			log.debug("debug");
			log.trace("trace");
		};
	}

}
