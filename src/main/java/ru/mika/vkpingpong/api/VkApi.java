package ru.mika.vkpingpong.api;

import retrofit2.Call;
import retrofit2.http.*;
import ru.mika.vkpingpong.dto.response.SendMessageResponse;

import java.util.Map;

public interface VkApi {

    @POST("method/messages.send")
    @FormUrlEncoded
    Call<SendMessageResponse> sendMessage(@FieldMap Map<String, Object> paramsMap);

}
