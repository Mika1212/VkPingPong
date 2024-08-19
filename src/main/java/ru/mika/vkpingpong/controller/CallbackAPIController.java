package ru.mika.vkpingpong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.helper.CallbackMessageHelper;
import ru.mika.vkpingpong.helper.MessageHandlerService;

import java.io.IOException;

/**
 * This class contains a controller responsible for handling responses from VK. It processes the incoming responses,
 * and triggers the actions necessary for further handle of the request.
 */
@RestController
@RequestMapping("/callback")
public class CallbackAPIController {
    private final MessageHandlerService callbackMessageHelper;
    public CallbackAPIController(@Autowired MessageHandlerService callbackMessageHelper) {
        this.callbackMessageHelper = callbackMessageHelper;
    }

    @PostMapping("/message")
    public ResponseEntity<String> handleMessageCallback(@RequestBody CallbackAPIMessageDTO callbackDTO) throws IOException {
        return new ResponseEntity<>(callbackMessageHelper.messageHandler(callbackDTO), HttpStatus.OK);
    }

}
