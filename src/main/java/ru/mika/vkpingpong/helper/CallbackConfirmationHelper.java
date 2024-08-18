package ru.mika.vkpingpong.helper;

import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

public class CallbackConfirmationHelper {

    public String confirmationHandler(CallbackAPIMessageDTO callbackDTO) {
        if (callbackDTO.getGroupId() == SecretConfig.getGroupId())
            return SecretConfig.getAcceptString();
        return null;
    }

}
