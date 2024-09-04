package com.example.corndetector.service.Chat;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    public Map<String,Object> generateByText(Map<String, Object> formData){
        String modelName = (String) formData.get("model_name");
        String userPrompt = (String) formData.get("user_prompt");

        Clip llm = new Clip(modelName);
        String result = llm.generateContent(userPrompt);

        Map<String,Object> map = new HashMap<>();
        map.put("data",result);

        return map;
    }
}
