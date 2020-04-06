package com.codelovin.h2demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

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
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
