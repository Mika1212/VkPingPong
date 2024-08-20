package ru.mika.vkpingpong.api;

import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class VkApiCreator {

    public VkApi create() {
        return new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(VkApi.class);
    }
}
