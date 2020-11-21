package by.ereut.balanceservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

@Configuration
public class TestConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("test")
    public JdbcDatabaseContainer jdbcDatabaseContainer() {
        return new MySQLContainer("mysql:5.5")
                .withInitScript("test-db.sql");
    }

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource =
                new DriverManagerDataSource(
                        jdbcDatabaseContainer().getJdbcUrl(),
                        jdbcDatabaseContainer().getUsername(),
                        jdbcDatabaseContainer().getPassword());
        driverManagerDataSource.setDriverClassName(jdbcDatabaseContainer().getDriverClassName());
        return driverManagerDataSource;
    }

}
