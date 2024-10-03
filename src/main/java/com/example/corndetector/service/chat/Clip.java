package com.example.corndetector.service.chat;

public class Clip {
    private final ClipClient client;

    private String modelName;

    public Clip(String modelName){
        this.modelName = modelName;
        this.client = new ClipClient();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String generateContent(String input){
        CompletionRequest r = new CompletionRequest();
        r.setModelName(modelName);
        r.setInput(input);

        Completion content = client.createCompletion(r);

        return content.getOutput();
    }
}
