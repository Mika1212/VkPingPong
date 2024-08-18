package ru.mika.vkpingpong.helper;

import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;

import java.io.IOException;

public class CallbackMessageHelper {

    public static String messageHandler(CallbackAPIMessageDTO callbackDTO) throws IOException {
        if (callbackDTO.getType() == CallbackAPIMessageDTO.MessageType.confirmation) {
            return CallbackConfirmationHelper.confirmationHandler(callbackDTO);
        }
        else {
            return CallbackUserNewMessageHelper.messageHandlerUserMessage(callbackDTO);
        }
    }
}
