package com.example.corndetector.service;

import com.example.corndetector.bo.chat.CLIP;
import com.example.corndetector.dto.chat.ChatTextRequest;
import com.example.corndetector.dto.chat.ChatTextResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatTextResponse generateByText(ChatTextRequest chatTextRequest){
        String modelName = chatTextRequest.getModelName();
        String input = chatTextRequest.getInput();
        CLIP llm = new CLIP(modelName);

        String output = llm.generateContent(input);
        ChatTextResponse chatTextResponse = new ChatTextResponse();
        chatTextResponse.setOutput(output);
        return chatTextResponse;
    }
}
