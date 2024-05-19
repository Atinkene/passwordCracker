import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
public class SecEyeXControle{
  

    public static HttpResponse<String> mdHttp(String url, Map<String, String> params) throws Exception{
        HttpClient client = HttpClient.newHttpClient();


        StringBuilder requestBody = new StringBuilder();
        for (Map.Entry<String,String> param : params.entrySet()) {
            if (requestBody.length() != 0) requestBody.append('&');
            requestBody.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            requestBody.append('=');
            requestBody.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;

        } catch (Exception e) {
           throw new Exception("on dirais qu'il y a eu un problème inattendu", null);
        }


    }

}