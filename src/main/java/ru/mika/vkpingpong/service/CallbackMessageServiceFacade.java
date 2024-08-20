package ru.mika.vkpingpong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

import java.security.InvalidParameterException;

/**
 * This class is responsible for handling incoming requests to the controller. It processes the requests by determining
 * the appropriate action based on the request type. If the request is for confirmation, the class will invoke the
 * confirmation handler. Alternatively, if the request is a message from the user, it will invoke the message handler.
 */
@Component
public class CallbackMessageServiceFacade implements MessageHandlerService {
    private final SecretConfig secretConfig;
    private final CallbackUserNewMessageService callbackUserNewMessageService;
    private final CallbackConfirmationService callbackConfirmationService;

    public CallbackMessageServiceFacade(
            @Autowired SecretConfig secretConfig,
            @Autowired CallbackUserNewMessageService callbackUserNewMessageService,
            @Autowired CallbackConfirmationService callbackConfirmationService
    )
    {
        this.callbackConfirmationService = callbackConfirmationService;
        this.callbackUserNewMessageService = callbackUserNewMessageService;
        this.secretConfig = secretConfig;
    }

    @Override
    public String handle(CallbackAPIMessageDTO callbackDTO) {
        secretCheck(callbackDTO);
        switch (callbackDTO.getType()) {
            case message_new -> {
                return callbackUserNewMessageService.execute(callbackDTO);
            }
            case confirmation -> {
                return callbackConfirmationService.execute(callbackDTO);
            }

            default -> throw new InvalidParameterException("Invalid message type");
        }
    }

    private void secretCheck(CallbackAPIMessageDTO callbackDTO) {
        if (!callbackDTO.getSecret().equals(secretConfig.getSecretKey())) {
            throw new InvalidParameterException("Invalid secret key");
        }
    }
}
