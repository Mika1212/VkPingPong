package ru.mika.vkpingpong.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mika.vkpingpong.config.SecretConfig;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CallbackMessageServiceFacadeTest {

    @Mock
    SecretConfig config;

    @Mock
    CallbackUserNewMessageService callbackUserNewMessageService;
    @Mock
    CallbackConfirmationService callbackConfirmationService;

    @InjectMocks
    CallbackMessageServiceFacade serviceFacade;

    @BeforeEach
    void setUp() {
    }

    @Test
    void test_whenFacadeHandle_checkSecretIsFalse() {
        when(config.getSecretKey()).thenReturn("WrongSecretKey");

        var callbackAPIMessageDTO = buildCallbackMessageDTO(CallbackAPIMessageDTO.MessageType.message_new);
        assertThrows(InvalidParameterException.class,
                () -> serviceFacade.handle(callbackAPIMessageDTO),
                "Invalid secret key");
        verifyNoMoreInteractions(callbackConfirmationService);
        verifyNoMoreInteractions(callbackUserNewMessageService);
    }

    @Test
    void test_whenFacadeHandleNewMessage_correctServiceIsCalled() {
        when(config.getSecretKey()).thenReturn("000");

        var callbackAPIMessageDTO = buildCallbackMessageDTO(CallbackAPIMessageDTO.MessageType.message_new);
        serviceFacade.handle(callbackAPIMessageDTO);
        verify(callbackUserNewMessageService, times(1)).execute(callbackAPIMessageDTO);
    }

    @Test
    void test_whenFacadeHandleConfirmation_correctServiceIsCalled() {
        when(config.getSecretKey()).thenReturn("000");

        var callbackAPIMessageDTO = buildCallbackMessageDTO(CallbackAPIMessageDTO.MessageType.confirmation);
        serviceFacade.handle(callbackAPIMessageDTO);
        verify(callbackConfirmationService, times(1)).execute(callbackAPIMessageDTO);
    }

    CallbackAPIMessageDTO buildCallbackMessageDTO(CallbackAPIMessageDTO.MessageType messageType) {
        CallbackAPIMessageDTO mockDTO = new CallbackAPIMessageDTO();
        var objectDTO = new CallbackAPIMessageDTO.CallbackObjectDTO();
        var messageDTO = new CallbackAPIMessageDTO.CallbackMessageDTO();
        messageDTO.setDate("000");
        messageDTO.setText("test");
        messageDTO.setFromId(1L);
        objectDTO.setMessage(messageDTO);
        mockDTO.setType(messageType);
        mockDTO.setObject(objectDTO);
        mockDTO.setV("V1");
        mockDTO.setSecret("000");
        return mockDTO;
    }

}


