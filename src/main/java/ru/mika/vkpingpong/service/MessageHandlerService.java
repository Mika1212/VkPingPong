package ru.mika.vkpingpong.service;

import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;

public interface MessageHandlerService {

    String handle(CallbackAPIMessageDTO callbackDTO);
}
