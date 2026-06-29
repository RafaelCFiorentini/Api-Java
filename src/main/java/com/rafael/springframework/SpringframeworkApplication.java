package com.rafael.springframework;

import com.rafael.springframework.principal.Principal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringframeworkApplication implements CommandLineRunner {

	@Value("${omdb.api.key}")
	private String omdbApiKey;

	public static void main(String[] args) {
		SpringApplication.run(SpringframeworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(omdbApiKey);
		principal.exibeMenu();
	}
}
