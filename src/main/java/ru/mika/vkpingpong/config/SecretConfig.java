package ru.mika.vkpingpong.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This class stores sensitive data crucial for the bot's operation. This data includes information such as API keys,
 * access tokens, and secret keys, which are essential for the bot to function correctly.
 */
@Configuration
@ConfigurationProperties("vk")
public class SecretConfig {
    private String acceptString;

    private String secretKey;
    private int groupId;
    private String accessToken;
    public String getAcceptString() {
        return acceptString;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getAccessToken() {return accessToken;}

    public void setSecretKey(String secretKeyNew) {
        secretKey = secretKeyNew;
    }
}
