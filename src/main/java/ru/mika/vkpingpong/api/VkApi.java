package ru.mika.vkpingpong.api;

import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.util.Map;

@Component
public interface VkApi {

    @POST("method/messages.send")
    @FormUrlEncoded
    Call<SendMessageResponse> sendMessage(@FieldMap Map<String, Object> paramsMap);

}
