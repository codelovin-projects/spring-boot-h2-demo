package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "/test.properties")
public class PropertySourceTest {

	@Value("${custom.message}")
	String msg;

	@Test
	void test() {
		System.out.println("\n\n\n" + msg + "\n\n\n");
		assertThat(msg).isEqualTo("Test");
	}
}
