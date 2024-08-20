package ru.mika.vkpingpong.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.config.SecretConfig;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;

import java.util.Random;

/**
 * This class is responsible for generating the URI used by the bot to send messages.
 */
@Component
public class VkClient {
    private final SecretConfig secretConfig;
    private final VkRepository vkRepository ;

    public VkClient(@Autowired SecretConfig secretConfig, @Autowired VkRepository vkRepository) {
        this.secretConfig = secretConfig;
        this.vkRepository = vkRepository;
    }

    public String processRequest(CallbackAPIMessageDTO callbackDTO) {
        Random rand = new Random();
        var message = callbackDTO.getObject().getMessage();
        long randomId = Long.parseLong(message.getDate()) * rand.nextInt(10000);
        var sendMessageRequest = SendMessageRequest.builder()
                .secret(secretConfig.getSecretKey())
                .userId(message.getFromId())
                .randomId(randomId)
                .message("Вы сказали: " + message.getText())
                .accessToken(secretConfig.getAccessToken())
                .v(callbackDTO.getV())
                .build();

        return vkRepository.send(sendMessageRequest).getResponse();
    }
}
