package ru.mika.vkpingpong.helper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
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
    final
    SecretConfig secretConfig;

    public CallbackMessageHelper(@Autowired SecretConfig secretConfig) {
        callbackConfirmationHelper = new CallbackConfirmationHelper();
        callbackUserNewMessageHelper = new CallbackUserNewMessageHelper();
        this.secretConfig = secretConfig;
    }

    private final CallbackUserNewMessageHelper callbackUserNewMessageHelper;
    private final CallbackConfirmationHelper callbackConfirmationHelper;

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
