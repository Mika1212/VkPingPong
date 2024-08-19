package ru.mika.vkpingpong.helper;

import org.springframework.stereotype.Service;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;

import java.io.IOException;

@Service
public interface MessageHandlerService {

    String messageHandler(CallbackAPIMessageDTO callbackDTO) throws IOException;
}
