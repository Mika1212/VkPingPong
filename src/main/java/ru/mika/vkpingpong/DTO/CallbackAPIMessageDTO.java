package ru.mika.vkpingpong.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.HashMap;

/**
 * This class defines a Data Transfer Object (DTO) structure for storing data received from VK. The DTO is designed
 * to encapsulate and organize the information retrieved from VK in a standardized format.
 */

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

    @JsonProperty(value = "group_id")
    private Long groupId;

    @JsonProperty(value = "event_id")
    private String eventId;

    private HashMap<String, Object> object;
    private String secret;
    private String v;
}
