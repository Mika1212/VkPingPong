package ru.mika.vkpingpong.helper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;

import java.io.IOException;
import java.util.LinkedHashMap;

import static ru.mika.vkpingpong.helper.CreateUri.createUri;

public class CallbackUserNewMessageHelper {
    public String messageHandlerUserMessage(CallbackAPIMessageDTO callbackDTO) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(createUri(callbackDTO).toURL()).build();
        Response response = client.newCall(request).execute();
        return response.message();
    }

}
