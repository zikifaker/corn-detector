package com.example.corndetector.service.Chat;

public class CompletionRequest {
    private String modelName;
    private String input;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
