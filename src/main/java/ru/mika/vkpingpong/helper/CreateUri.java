package ru.mika.vkpingpong.helper;

import org.springframework.web.util.UriComponentsBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.VkApi;
import ru.mika.vkpingpong.config.SecretConfig;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * This class is responsible for generating the URI used by the bot to send messages.
 */
public class CreateUri {

    public static URI createUri(CallbackAPIMessageDTO callbackDTO) {
        LinkedHashMap<String, Object> map = (LinkedHashMap) callbackDTO.getObject().get("message");
        Random rand = new Random();
        long random_id = Long.parseLong(map.get("date").toString()) * rand.nextInt(10000);

        return UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("access_token", SecretConfig.getAccessToken())
                .queryParam("user_id", map.get("from_id").toString())
                .queryParam("random_id", random_id)
                .queryParam("message", "Вы сказали: " + map.get("text"))
                .queryParam("v", callbackDTO.getV())
                .build()
                .toUri();
    }
}
