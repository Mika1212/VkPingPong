package ru.mika.vkpingpong.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;
import retrofit2.Response;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VkRepositoryTest {

    @Mock
    VkApiCreator vkApiCreator;

    @Mock
    Call<SendMessageResponse> responseCall;

    @Mock
    Response<SendMessageResponse> sendMessageResponse;

    @Mock
    VkApi vkApi;

    @InjectMocks
    VkRepository vkRepository;

    @Captor
    private ArgumentCaptor<Map<String, Object>> captor;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sendCorrectData() throws IOException {
        when(vkApi.sendMessage(any())).thenReturn(responseCall);
        when(responseCall.execute()).thenReturn(sendMessageResponse);
        when(sendMessageResponse.body()).thenReturn(buildMockResponse());
        when(vkApiCreator.create()).thenReturn(vkApi);

        SendMessageRequest request = buildRequest();
        vkRepository.send(request);
        verify(vkApi).sendMessage(captor.capture());

        assertEquals(request.getV(), captor.getValue().get("v"));
        assertEquals(request.getMessage(), captor.getValue().get("message"));
        assertEquals(request.getRandomId(), captor.getValue().get("random_id"));
        assertEquals(request.getUserId(), captor.getValue().get("user_id"));
        assertEquals(request.getSecret(), captor.getValue().get("secret"));
    }

    SendMessageResponse buildMockResponse() {
        SendMessageResponse mockResponse = new SendMessageResponse("success");
        return mockResponse;
    }

    SendMessageRequest buildRequest() {
        return SendMessageRequest.builder()
                .secret("secret")
                .userId(1L)
                .randomId(0L)
                .message("test")
                .accessToken("access")
                .v("test")
                .build();
    }
}