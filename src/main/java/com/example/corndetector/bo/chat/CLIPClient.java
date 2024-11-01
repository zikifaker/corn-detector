package com.example.corndetector.bo.chat;

import com.example.corndetector.dto.chat.Completion;
import com.example.corndetector.dto.chat.CompletionRequest;
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
import java.util.Optional;

public class CLIPClient {
    private static final String BASE_URL = "http://47.100.189.13";

    private static final CloseableHttpClient client = HttpClients.createDefault();

    private static final Logger logger = LoggerFactory.getLogger(CLIPClient.class);

    public Optional<Completion> createCompletion(CompletionRequest r){
        try{
            String jsonBody = marshalRequest(r);
            HttpPost request = createRequest(jsonBody);
            HttpResponse response = executeRequest(request);
            return Optional.of(unmarshalResponse(response));
        } catch (IOException e) {
            logger.info("failed to create a completion: {}", e.getMessage());
        }
        return Optional.empty();
    }

    private String marshalRequest(CompletionRequest r) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(r);
    }

    private HttpPost createRequest(String jsonBody) throws IOException {
        HttpPost request = new HttpPost(BASE_URL);
        request.setHeader("Content-type", "application/json");
        request.setEntity(new StringEntity(jsonBody));
        return request;
    }

    private HttpResponse executeRequest(HttpPost request) throws IOException{
        return client.execute(request);
    }

    private Completion unmarshalResponse(HttpResponse response) throws IOException {
        String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, Completion.class);
    }
}
