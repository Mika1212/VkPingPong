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
    private static final String acceptString = "";

    private String secretKey;
    private static final int groupId = ;
    private static final String accessToken = ;
    public static String getAcceptString() {
        return acceptString;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public static int getGroupId() {
        return groupId;
    }

    public static String getAccessToken() {return accessToken;}

    public void setSecretKey(String secretKeyNew) {
        secretKey = secretKeyNew;
    }
}
