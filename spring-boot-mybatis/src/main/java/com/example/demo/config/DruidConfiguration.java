package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfiguration {

	@ConditionalOnClass(DruidDataSource.class)
	@ConditionalOnProperty(name="spring.datasource.type", 
		havingValue="com.alibaba.druid.pool.DruidDataSource",
		matchIfMissing=true)		
	static class Druid extends DruidConfiguration{
		
		@Bean
		@ConfigurationProperties("spring.datasource.druid")
		public DruidDataSource dataSource(DataSourceProperties properties) {
			DruidDataSource dds = (DruidDataSource) properties.initializeDataSourceBuilder()
					.type(DruidDataSource.class).build();
			
			DatabaseDriver dd = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
			String validationQuery = dd.getValidationQuery();
			if(validationQuery != null) {
				dds.setValidationQuery(validationQuery);
			}
			return dds;
		}
	}
}
