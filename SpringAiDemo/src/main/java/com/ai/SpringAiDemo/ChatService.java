package com.ai.SpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final HuggingfaceChatModel chatModel;

    public ChatService(HuggingfaceChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }
}
