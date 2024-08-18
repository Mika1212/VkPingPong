package ru.mika.vkpingpong.config;

public class SecretConfig {
    private static final String acceptString = "99077c5b";
    private static final String secretKey = "secretKeyVkBotJustAISecretVerySecret123";
    private static final int groupId = 226973454;
    private static final String accessToken = "vk1.a.oNUTB2lOsg9STxRXesuKl9SSdaG0SWYL1qUS-UP8T2eMWH4b39PwU-R2n8_oW07sKMbgmBtjtdaxqmZfD2xl7RTNAgDdoN9XqHiK5qE96sHk1mXsAsmdIj2vn3ogFDKZJnKvV8eky4Vv4p6k54mWCBqPYZ6DSSUbmdJKVNBPiO1gXMX6pQVh6iYaMQ606MT7BeHePjaF48UisEFevweQAw";

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
