package com.sinan.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Configurations regarding our DAO layer
 *
 * @author Pezhman Jahanmard
 */
@ComponentScan("com.sinan.test")
@Configuration
@EnableJpaRepositories("com.sinan.test.dao")
public class DAOConfig {
	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
