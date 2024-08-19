package ru.mika.vkpingpong.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

/**
 * This class is responsible for confirming requests from the VK server to establish a connection with the address
 * configured in the VK settings.
 */
@Component
public class CallbackConfirmationHelper {
    @Autowired
    SecretConfig secretConfig;

    public String confirmationHandler(CallbackAPIMessageDTO callbackDTO) {
        if (callbackDTO.getGroupId() == secretConfig.getGroupId())
            return secretConfig.getAcceptString();
        return null;
    }

}
