package com.example.corndetector.service.chat;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    public Map<String,Object> generateByText(Map<String, Object> formData){
        String modelName = (String) formData.get("model_name");
        String input = (String) formData.get("input");

        CLIP llm = new CLIP(modelName);
        String result = llm.generateContent(input);

        Map<String,Object> map = new HashMap<>();
        map.put("data",result);

        return map;
    }
}
