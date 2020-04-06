package com.codelovin.h2demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
@SpringBootApplication
public class H2demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
	    AcceptHeaderLocaleResolver ahResolver = new AcceptHeaderLocaleResolver();
	    ahResolver.setDefaultLocale(Locale.US);
	    return ahResolver;
	}

}
