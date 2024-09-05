package com.example.corndetector.service.chat;

public class Clip {
    private ClipClient client;
    private String modelName;

    public Clip(String modelName){
        this.modelName = modelName;
        client = new ClipClient(modelName);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String generateContent(String prompt){
        CompletionRequest r = new CompletionRequest();
        r.setModelName(modelName);
        r.setInput(prompt);

        return client.createCompletion(r);
    }
}
