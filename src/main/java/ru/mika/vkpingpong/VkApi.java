package ru.mika.vkpingpong;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;

public interface VkApi {

    @POST("callback/message")

    Call<CallbackAPIMessageDTO> createUser(@Body CallbackAPIMessageDTO messageDTO);
}
