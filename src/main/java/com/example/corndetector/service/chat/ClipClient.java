package com.example.corndetector.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ClipClient {
    private static final String BASE_URL = "http://47.100.189.13";
    private static final Logger logger = LoggerFactory.getLogger(ClipClient.class);
    // a mapper for parsing object to json-form data
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final CloseableHttpClient client = HttpClients.createDefault();

    public ClipClient(){}

    public Completion createCompletion(CompletionRequest r){
        try{
            String jsonBody = objectMapper.writeValueAsString(r);
            StringEntity body = new StringEntity(jsonBody);

            HttpPost request = new HttpPost(BASE_URL);
            request.setHeader("Content-type","application/json");
            request.setEntity(body);

            HttpResponse response = client.execute(request);

            String responseBody = EntityUtils.toString(response.getEntity(),"UTF-8");
            return objectMapper.readValue(responseBody,Completion.class);
        }catch (IOException err){
            logger.info(err.getMessage());
        }
        return null;
    }
}
