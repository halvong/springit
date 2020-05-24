package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
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
@EnableJpaAuditing
public class SpringitApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {

				Link link = new Link("AltaVista is my old search engine","https://www.altavista.com");
				linkRepository.save(link);

				Comment comment = new Comment("AltaVista gives free dialup.", link);
				commentRepository.save(comment);

				System.out.println("Just inserted a link and comment");

				Link firstLink = linkRepository.findByTitle("AltaVista is my old search engine");
				System.out.println(firstLink.getTitle());
		};
	}

}
