package ru.mika.vkpingpong.controller;

//import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mika.vkpingpong.DTO.CallbackAPIConfirmationDTO;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.helper.CallbackConfirmationHelper;
import ru.mika.vkpingpong.helper.CallbackMessageHelper;

import java.io.IOException;

@RestController
@RequestMapping("/callback")
public class CallbackAPIController {

    @PostMapping("/confirmation")
    public ResponseEntity<String> handleConfirmationCallback(@RequestBody CallbackAPIConfirmationDTO callbackDTO) {
        return new ResponseEntity<>(CallbackConfirmationHelper.confirmationHandler(callbackDTO), HttpStatus.OK);
    }

    @PostMapping("/message")
    public ResponseEntity<String> handleMessageCallback(@RequestBody CallbackAPIMessageDTO callbackDTO) throws IOException {
        return new ResponseEntity<>(CallbackMessageHelper.messageHandler(callbackDTO), HttpStatus.OK);
    }

}
