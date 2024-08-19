package ru.mika.vkpingpong.helper;

import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

/**
 * This class is responsible for confirming requests from the VK server to establish a connection with the address
 * configured in the VK settings.
 */
public class CallbackConfirmationHelper {

    public String confirmationHandler(CallbackAPIMessageDTO callbackDTO) {
        if (callbackDTO.getGroupId() == SecretConfig.getGroupId())
            return SecretConfig.getAcceptString();
        return null;
    }

}
