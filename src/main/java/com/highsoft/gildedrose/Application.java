package com.highsoft.gildedrose;

import com.highsoft.gildedrose.config.GildedRoseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(GildedRoseConfiguration.class)
@SpringBootApplication(scanBasePackages = "com.highsoft.gildedrose")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
