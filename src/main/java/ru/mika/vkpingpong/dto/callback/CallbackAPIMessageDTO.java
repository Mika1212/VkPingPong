package ru.mika.vkpingpong.dto.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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

    private CallbackObjectDTO object;

    private String secret;
    private String v;


    @Data
    public static class CallbackObjectDTO {

        CallbackMessageDTO message;

    }
    @Data
    public static class CallbackMessageDTO {

        @JsonProperty(value = "from_id")
        Long fromId;
        String text;
        String date;
    }

}
