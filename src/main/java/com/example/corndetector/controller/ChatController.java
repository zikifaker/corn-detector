package com.example.corndetector.controller;

import com.example.corndetector.dto.chat.ChatTextRequest;
import com.example.corndetector.dto.chat.ChatTextResponse;
import com.example.corndetector.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/text")
    public ChatTextResponse generateByTextAPI(@RequestBody ChatTextRequest chatTextRequest){
        return chatService.generateByText(chatTextRequest);
    }
}
