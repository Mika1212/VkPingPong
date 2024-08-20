package ru.mika.vkpingpong.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.util.Map;

@Component
public class VkRepository {

    private final VkApi vkApi;

    public VkRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.vkApi = retrofit.create(VkApi.class);
    }

    public SendMessageResponse send(SendMessageRequest request) {
        var objectMapper = new ObjectMapper();
        Map<String, Object> paramsMap = objectMapper.convertValue(request, new TypeReference<>() {});
        try {
            return vkApi.sendMessage(paramsMap).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
