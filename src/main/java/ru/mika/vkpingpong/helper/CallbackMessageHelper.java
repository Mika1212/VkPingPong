package ru.mika.vkpingpong.helper;

import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

import java.io.IOException;
import java.security.InvalidParameterException;

public class CallbackMessageHelper {
    public CallbackMessageHelper() {
        callbackConfirmationHelper = new CallbackConfirmationHelper();
        callbackUserNewMessageHelper = new CallbackUserNewMessageHelper();
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

    public static void secretCheck(CallbackAPIMessageDTO callbackDTO) {
        if (!callbackDTO.getSecret().equals(SecretConfig.getSecretKey())) {
            throw new InvalidParameterException("Invalid secret key");
        }
    }
}
