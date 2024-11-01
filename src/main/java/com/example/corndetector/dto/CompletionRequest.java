package com.example.corndetector.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletionRequest {
    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("input")
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
