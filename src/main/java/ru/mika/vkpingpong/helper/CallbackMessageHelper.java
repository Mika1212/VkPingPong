package ru.mika.vkpingpong.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * This class is responsible for handling incoming requests to the controller. It processes the requests by determining
 * the appropriate action based on the request type. If the request is for confirmation, the class will invoke the
 * confirmation handler. Alternatively, if the request is a message from the user, it will invoke the message handler.
 */


@Component
public class CallbackMessageHelper implements MessageHandlerService {
    private final SecretConfig secretConfig;
    private final CallbackUserNewMessageHelper callbackUserNewMessageHelper;
    private final CallbackConfirmationHelper callbackConfirmationHelper;

    public CallbackMessageHelper(
            @Autowired SecretConfig secretConfig,
            @Autowired CallbackUserNewMessageHelper callbackUserNewMessageHelper,
            @Autowired CallbackConfirmationHelper callbackConfirmationHelper
    )
    {
        this.callbackConfirmationHelper = callbackConfirmationHelper;
        this.callbackUserNewMessageHelper = callbackUserNewMessageHelper;
        this.secretConfig = secretConfig;
    }

    public String messageHandler(CallbackAPIMessageDTO callbackDTO) throws IOException {
        secretCheck(callbackDTO);
        switch (callbackDTO.getType()) {
            case message_new -> {
                return callbackUserNewMessageHelper.messageHandlerUserMessage(callbackDTO);
            }
            case confirmation -> {
                return callbackConfirmationHelper.confirmationHandler(callbackDTO);
            }

            default -> {
                throw new InvalidParameterException("Invalid message type");
            }
        }
    }

    public void secretCheck(CallbackAPIMessageDTO callbackDTO) {
        if (!callbackDTO.getSecret().equals(secretConfig.getSecretKey())) {
            throw new InvalidParameterException("Invalid secret key");
        }
    }
}
