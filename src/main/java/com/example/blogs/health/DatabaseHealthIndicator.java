package com.example.blogs.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Health health() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return Health.up().withDetail("database", "PostgreSQL").build();
        } catch (Exception e) {
            return Health.down(e).withDetail("error", "Cannot connect to the database").build();
        }
    }
}
