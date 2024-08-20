package ru.mika.vkpingpong.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.util.Map;

@Component
public class VkRepository {

    private final VkApiCreator apiCreator;

    public VkRepository(VkApiCreator apiCreator) {
        this.apiCreator = apiCreator;
    }

    public SendMessageResponse send(SendMessageRequest request) {
        var objectMapper = new ObjectMapper();
        Map<String, Object> paramsMap = objectMapper.convertValue(request, new TypeReference<>() {});
        try {
            VkApi vkApi = apiCreator.create();
            Call<SendMessageResponse> responseCall = vkApi.sendMessage(paramsMap);
            return responseCall.execute().body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
