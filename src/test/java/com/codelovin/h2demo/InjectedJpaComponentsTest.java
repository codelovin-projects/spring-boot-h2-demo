package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
public class InjectedJpaComponentsTest {

	  @Autowired 
	  private DataSource dataSource;
	  
	  @Autowired 
	  private JdbcTemplate jdbcTemplate;
	  
	  @Autowired 
	  private EntityManager entityManager;
	  
	  @Autowired 
	  private PersonRepository personRepository;
	  
	  @Test
	  void injectedJpaComponentsAreNotNull(){
	    assertThat(dataSource).isNotNull();
	    assertThat(jdbcTemplate).isNotNull();
	    assertThat(entityManager).isNotNull();
	    assertThat(personRepository).isNotNull();
	  }
}
