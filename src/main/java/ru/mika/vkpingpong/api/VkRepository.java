package ru.mika.vkpingpong.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import ru.mika.vkpingpong.dto.request.SendMessageRequest;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.util.*;

@Component
public class VkRepository {

    private final VkApiCreator apiCreator;

    private final Map<Long, List<Long>> callbacksMap = new HashMap<>();

    public VkRepository(VkApiCreator apiCreator) {
        this.apiCreator = apiCreator;
    }

    public SendMessageResponse send(SendMessageRequest request) {
        if (callbacksMap.containsKey(request.getUserId())) {
            for (Long id: callbacksMap.get(request.getUserId())) {
                if (Objects.equals(id, request.getRandomId())) {
                    return null;
                }
            }
        }
        var objectMapper = new ObjectMapper();
        Map<String, Object> paramsMap = objectMapper.convertValue(request, new TypeReference<>() {});
        try {
            VkApi vkApi = apiCreator.create();
            Call<SendMessageResponse> responseCall = vkApi.sendMessage(paramsMap);
            Response<SendMessageResponse> response = responseCall.execute();
            List<Long> randomIdList = callbacksMap.getOrDefault(request.getUserId(), new ArrayList<>());
            randomIdList.add(request.getRandomId());
            callbacksMap.put(request.getUserId(), randomIdList);
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
