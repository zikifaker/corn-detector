package com.example.corndetector.service.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Completion {
    @JsonProperty("model_name")
    private String modelName;
    @JsonProperty("output")
    private String output;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getoutput() {
        return output;
    }

    public void setoutput(String output) {
        this.output = output;
    }
}
