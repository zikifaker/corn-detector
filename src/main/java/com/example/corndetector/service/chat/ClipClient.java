package com.example.corndetector.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ClipClient {
    private static final String BASE_URL = "http://localhost:5000/";
    // a mapper for parsing object to json-form data
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static CloseableHttpClient client = HttpClients.createDefault();
    private String modelName;

    public ClipClient(String modelName){
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String createCompletion(CompletionRequest r){
        try{
            String jsonBody = objectMapper.writeValueAsString(r);
            StringEntity body = new StringEntity(jsonBody);

            HttpPost request = new HttpPost(BASE_URL);
            request.setHeader("Content-type","application/json");
            request.setEntity(body);

            HttpResponse response = client.execute(request);
            return EntityUtils.toString(response.getEntity(),"UTF-8");
        }catch (IOException err){
            err.printStackTrace();
        }
        return null;
    }
}
