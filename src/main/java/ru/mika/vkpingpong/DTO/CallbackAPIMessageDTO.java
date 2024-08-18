package ru.mika.vkpingpong.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.HashMap;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackAPIMessageDTO {
    public enum MessageType {
        message_new, confirmation
    }

    private MessageType type;
    private HashMap<String, Object> object;
    @JsonProperty(value = "group_id")
    private Long groupId;
    private String secret;
    @JsonProperty(value = "event_id")
    private String eventId;
    private String v;


    /*
    private String secret;
    private Message object;


    public CallbackAPIMessageDTO(String secret, Message object) {
        this.object = object;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public Message getObject() {
        return object;
    }

     */

}
