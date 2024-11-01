package com.example.corndetector.bo.chat;

import com.example.corndetector.dto.chat.Completion;
import com.example.corndetector.dto.chat.CompletionRequest;

public class CLIP {
    private CLIPClient client;

    private String modelName;

    public CLIP(String modelName){
        this.client = new CLIPClient();
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String generateContent(String input){
        CompletionRequest request = new CompletionRequest();
        request.setModelName(this.modelName);
        request.setInput(input);
        return client.createCompletion(request)
                .map(Completion::getOutput)
                .orElse("");
    }
}