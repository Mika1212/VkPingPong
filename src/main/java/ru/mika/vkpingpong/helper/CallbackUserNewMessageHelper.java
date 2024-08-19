package ru.mika.vkpingpong.helper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mika.vkpingpong.DTO.CallbackAPIMessageDTO;

import java.io.IOException;

/**
 * This class is responsible for processing messages received from the user and generating appropriate response
 * from the bot.
 */
@Component
public class CallbackUserNewMessageHelper {
    @Autowired
    CreateUri createUri;

    public String messageHandlerUserMessage(CallbackAPIMessageDTO callbackDTO) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(createUri.createUri(callbackDTO).toURL()).build();
        Response response = client.newCall(request).execute();
        return response.message();
    }

}
