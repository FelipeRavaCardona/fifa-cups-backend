package com.piriurna.fifacups.config.database;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class DataSourceConfig {
    private Map<String, String> databaseCredentials;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + databaseCredentials.get("endpoint") + "/" + databaseCredentials.get("db_name"));
        dataSource.setUsername(databaseCredentials.get("username"));
        dataSource.setPassword(databaseCredentials.get("password"));
        return dataSource;
    }
}
