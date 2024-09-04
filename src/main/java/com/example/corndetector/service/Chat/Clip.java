package com.example.corndetector.service.Chat;

public class Clip {
    private String modelName;
    private final ClipClient client;

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
