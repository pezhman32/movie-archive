package com.sinan.test;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.*;

import java.sql.Driver;
import javax.sql.DataSource;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	private static final String DATABASE_NAME = "application_db";
	private static final String DATABASE_SCHEMA = "sql/ddl.sql";
	private static final String DATABASE_SAMPLE_DATA = "sql/sample_data.sql";
	private static final String DATABASE_URL = "jdbc:h2:mem:application_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "123456";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * This bean Creates embedded h2 database
	 */
	@Bean
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

		EmbeddedDatabase db = builder
				.setDataSourceFactory(getDataSourceFactory())
				.setType(EmbeddedDatabaseType.H2)
				.setName(DATABASE_NAME)
				.addScript(DATABASE_SCHEMA)
				.addScript(DATABASE_SAMPLE_DATA)
				.build();
		return db;
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}

	private DataSourceFactory getDataSourceFactory() {
		return new DataSourceFactory() {
			private final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			@Override
			public ConnectionProperties getConnectionProperties() {
				return getMyConnectionProperties(dataSource);
			}

			@Override
			public DataSource getDataSource() {
				return dataSource;
			}
		};
	}

	private ConnectionProperties getMyConnectionProperties(SimpleDriverDataSource dataSource) {
		return new ConnectionProperties() {
			@Override
			public void setDriverClass(Class<? extends Driver> aClass) {
				dataSource.setDriverClass(org.h2.Driver.class);
			}

			@Override
			public void setUrl(String s) {
				dataSource.setUrl(DATABASE_URL);
			}

			@Override
			public void setUsername(String s) {
				dataSource.setUsername(DATABASE_USERNAME);
			}

			@Override
			public void setPassword(String s) {
				dataSource.setPassword(DATABASE_PASSWORD);
			}
		};
	}
}
