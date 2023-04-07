package poc.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SentReservation{

    public static void ToHospital(String hospitalName)
    {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String json = String.format("{\"nom\": \"%s\"}", hospitalName);

        HttpPost request = new HttpPost("http://localhost:8080/hospital/nom");
        StringEntity params = null;

        try {
            params = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            HttpResponse response = null;
        try {
            response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
