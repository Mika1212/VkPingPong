package ru.mika.vkpingpong.service;

import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;

public interface MessageExecutorService {

    String execute(CallbackAPIMessageDTO callbackDTO);

}
