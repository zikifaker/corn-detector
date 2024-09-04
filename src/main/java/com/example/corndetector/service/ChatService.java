package com.example.corndetector.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    public Map<String,Object> generateByText(Map<String, Object> formData){
        String modelName = (String) formData.get("model_name");
        String userPrompt = (String) formData.get("user_prompt");
        //TODO: send a http request with userPrompt to CLIP service, then parse a response
        Map<String,Object> map = new HashMap<>();
        map.put("result","ni hao");
        return map;
    }
}
