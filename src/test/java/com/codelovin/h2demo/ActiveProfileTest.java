package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ActiveProfileTest {

	@Value("${test.hello}")
	String hello;

	@Test
	void test() {
		System.out.println("\n\n\n" + hello + "\n\n\n");
		assertThat(hello).isEqualTo("Hello");
	}
}