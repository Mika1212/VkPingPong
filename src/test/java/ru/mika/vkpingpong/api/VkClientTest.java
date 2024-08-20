package ru.mika.vkpingpong.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mika.vkpingpong.config.SecretConfig;
import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VkClientTest {

    @Mock
    SecretConfig config;
    @Mock
    VkRepository vkRepository;
    @InjectMocks
    VkClient vkClient;

    @Captor
    private ArgumentCaptor<SendMessageRequest> captor;

    @BeforeEach
    void setUp() {

    }

    @Test
    void test_whenProcessRequestWithCorrectMessage_Success() {
        when(config.getSecretKey()).thenReturn("000");
        when(config.getAccessToken()).thenReturn("111");
        when(vkRepository.send(any())).thenReturn(buildMockResponse());

        var callbackAPIMessageDTO = buildCallbackMessageDTO();
        vkClient.processRequest(callbackAPIMessageDTO);

        verify(vkRepository).send(captor.capture());
        assertEquals("V1", captor.getValue().getV());
        assertEquals("Вы сказали: test", captor.getValue().getMessage());
        assertEquals(0L, captor.getValue().getRandomId());
        assertEquals(config.getAccessToken(), captor.getValue().getAccessToken());
        assertEquals(1L, captor.getValue().getUserId());
        assertEquals(config.getSecretKey(), captor.getValue().getSecret());
    }

    SendMessageResponse buildMockResponse() {
        SendMessageResponse mockResponse = new SendMessageResponse("success");
        return mockResponse;
    }

    CallbackAPIMessageDTO buildCallbackMessageDTO() {
        CallbackAPIMessageDTO mockDTO = new CallbackAPIMessageDTO();
        var objectDTO = new CallbackAPIMessageDTO.CallbackObjectDTO();
        var messageDTO = new CallbackAPIMessageDTO.CallbackMessageDTO();
        messageDTO.setDate("000");
        messageDTO.setText("test");
        messageDTO.setFromId(1L);
        objectDTO.setMessage(messageDTO);
        mockDTO.setObject(objectDTO);
        mockDTO.setV("V1");
        mockDTO.setSecret("000");
        return mockDTO;
    }

}