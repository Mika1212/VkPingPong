package ru.mika.vkpingpong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.mika.vkpingpong.config.SecretConfig;

/**
 * Main application.
 */
@EnableConfigurationProperties({SecretConfig.class})
@SpringBootApplication
public class BotApplication {
    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
    }
}