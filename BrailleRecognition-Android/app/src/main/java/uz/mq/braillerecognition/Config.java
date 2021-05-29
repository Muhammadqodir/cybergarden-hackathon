package uz.mq.braillerecognition;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.File;


public class Config {
    public static String BR_SERVER_URL = "BR_SERVER_URL";
    public static String EMAIL = "your email";

    public static RequestBody getFormBody(String token){
        return new FormEncodingBuilder()
                .add("csrf_token", token)
                .add("e_mail", EMAIL)
                .add("submit", "Войти")
                .build();
    }

    public static RequestBody getRecognizeFormBody(String token, String lang, File file){
        final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/jpeg");
        return new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addFormDataPart("csrf_token", token)
                .addFormDataPart("lang", lang)
                .addFormDataPart("agree", "y")
                .addFormDataPart("find_orientation", "y")
                .addFormDataPart("file","profile.jpg", RequestBody.create(MEDIA_TYPE_PNG, file))
                .build();
    }
}
