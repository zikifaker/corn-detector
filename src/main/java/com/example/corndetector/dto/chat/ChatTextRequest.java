package com.example.corndetector.dto.chat;

public class ChatTextRequest {
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
