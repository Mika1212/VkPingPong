package ru.mika.vkpingpong.DTO;

public class Message {
    private String from_id;
    private String text;
    private String accessToken;

    Message (String from_id, String text, String accessToken) {
        this.from_id = from_id;
        this.text = text;
        this.accessToken = accessToken;
    }

    public String getFrom_id() {
        return from_id;
    }

    public String getText() {
        return text;
    }

    public String getAccessToken() {
        return accessToken;
    }
}