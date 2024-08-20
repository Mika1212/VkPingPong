package ru.mika.vkpingpong.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageRequest implements Serializable {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "user_id")
    private Long userId;
    @JsonProperty(value = "random_id")
    private Long randomId;
    private String message;
    private String v;
    private String secret;
}