package ru.mika.vkpingpong.helper;

import ru.mika.vkpingpong.DTO.CallbackAPIConfirmationDTO;
import ru.mika.vkpingpong.config.SecretConfig;

public class CallbackConfirmationHelper {

    public static String confirmationHandler(CallbackAPIConfirmationDTO callbackDTO) {
        if (callbackDTO.getType().equals("confirmation") && callbackDTO.getGroup_id() == SecretConfig.getGroupId())
            return SecretConfig.getAcceptString();
        return null;
    }

}
