package ru.mika.vkpingpong.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;

import java.io.IOException;

/**
 * This class is responsible for processing messages received from the user and generating appropriate response
 * from the bot.
 */
@Component
public class CallbackUserNewMessageHelper {
    private final VkClient client;

    public CallbackUserNewMessageHelper(@Autowired VkClient client) {
        this.client = client;
    }

    public String messageHandlerUserMessage(CallbackAPIMessageDTO callbackDTO) throws IOException {
        return client.createUri(callbackDTO);
    }

}
