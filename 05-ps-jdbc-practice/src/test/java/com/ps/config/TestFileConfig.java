package com.ps.config;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@Profile("dev")
@PropertySource("classpath:db/db.properties")
public class TestFileConfig {
	  @Value("${driverClassName}")
	    private String driverClassName;
	    @Value("${url}")
	    private String url;
	    @Value("${username}")
	    private String username;
	    @Value("${password}")
	    private String password;

	    @Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }

	    
	    @Bean
	    public DataSource dataSource() {
	        try {
	            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
	            dataSource.setDriverClass(driver);
	            dataSource.setUrl(url);
	            dataSource.setUsername(username);
	            dataSource.setPassword(password);
	            DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
	            return dataSource;
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    @Value("classpath:db/schema.sql")
	    private Resource schemaScript;
	    @Value("classpath:db/schema2.sql")
	    private Resource schemaScript2;
	    @Value("classpath:db/schema3.sql")
	    private Resource schemaScript3;	    
	    @Value("classpath:db/test-data.sql")
	    private Resource dataScript;

	    private DatabasePopulator databasePopulator() {
	        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	        populator.addScript(schemaScript);
	        populator.addScript(schemaScript2);
	        populator.addScript(schemaScript3);
	        populator.addScript(dataScript);
	        return populator;
	    }

}
