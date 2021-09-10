package com.highsoft.gildedrose;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

public class TestContainersInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:12.6-alpine");

    private static Map<String, Object> createConnectionConfiguration() {
        return Map.of(
                "spring.datasource.url", postgres.getJdbcUrl(),
                "spring.datasource.username", postgres.getUsername(),
                "spring.datasource.password", postgres.getPassword()
        );
    }

    private static void startContainers() {
        Startables.deepStart(Stream.of(postgres)).join();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        startContainers();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MapPropertySource testContainers = new MapPropertySource("testcontainers", createConnectionConfiguration());
        environment.getPropertySources().addFirst(testContainers);
    }
}
