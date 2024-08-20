package ru.mika.vkpingpong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.api.VkClient;

/**
 * This class is responsible for processing messages received from the user and generating appropriate response
 * from the bot.
 */
@Component
public class CallbackUserNewMessageService implements MessageExecutorService{
    private final VkClient client;

    public CallbackUserNewMessageService(@Autowired VkClient client) {
        this.client = client;
    }

    @Override
    public String execute(CallbackAPIMessageDTO callbackDTO){
        return client.processRequest(callbackDTO);
    }
}
