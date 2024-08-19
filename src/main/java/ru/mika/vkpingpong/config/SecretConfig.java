package ru.mika.vkpingpong.config;

/**
 * This class stores sensitive data crucial for the bot's operation. This data includes information such as API keys,
 * access tokens, and secret keys, which are essential for the bot to function correctly.
 */
public class SecretConfig {
    private static final String acceptString = "";
    private static final String secretKey = "";
    private static final int groupId = ;
    private static final String accessToken = "";

    public static String getAcceptString() {
        return acceptString;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public static int getGroupId() {
        return groupId;
    }

    public static String getAccessToken() {return accessToken;}
}
