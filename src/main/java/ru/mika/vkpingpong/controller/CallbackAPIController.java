package ru.mika.vkpingpong.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.helper.CallbackMessageHelper;

import java.io.IOException;

@RestController
@RequestMapping("/callback")
public class CallbackAPIController {
    @PostMapping("/message")
    public ResponseEntity<String> handleMessageCallback(@RequestBody CallbackAPIMessageDTO callbackDTO) throws IOException {
        return new ResponseEntity<>(CallbackMessageHelper.messageHandler(callbackDTO), HttpStatus.OK);
    }

}
