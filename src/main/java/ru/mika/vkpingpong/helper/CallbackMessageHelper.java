package ru.mika.vkpingpong.helper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.util.UriComponentsBuilder;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;
import ru.mika.vkpingpong.config.SecretConfig;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashMap;

public class CallbackMessageHelper {
    public static String messageHandler(CallbackAPIMessageDTO callbackDTO) throws IOException {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) callbackDTO.getObject().get("message");
        long random_id = Long.parseLong(map.get("date").toString());
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("access_token", SecretConfig.getAccessToken())
                .queryParam("user_id", map.get("from_id").toString())
                .queryParam("random_id", random_id)
                .queryParam("message", "Вы сказали: " + map.get("text"))
                .queryParam("v", callbackDTO.getV())
                .build()
                .toUri();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(uri.toURL()).build();
        Response response = client.newCall(request).execute();

        System.out.println(request.urlString());
        return response.message();
    }
}
