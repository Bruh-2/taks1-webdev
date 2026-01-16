package com.ehu.javacafe.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.H2Dialect;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories(basePackages = "com.ehu.javacafe.repository")
public class DatabaseConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    // H2 DataSource bean
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring H2 embedded database");
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql") // make sure schema.sql is in resources
                .build();
        logger.info("H2 database configured successfully");
        return dataSource;
    }

    // JdbcTemplate bean for database operations
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        logger.info("Creating JdbcTemplate bean");
        return new JdbcTemplate(dataSource);
    }

    // Provide Dialect for Spring Data JDBC
    @Bean
    public Dialect dialect() {
        logger.info("Providing H2 Dialect for Spring Data JDBC");
        return H2Dialect.INSTANCE;
    }
}
