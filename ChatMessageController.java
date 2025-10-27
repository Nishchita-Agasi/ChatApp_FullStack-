package com.chatapp;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    @MessageMapping("/sendMessage") // client sends here
    @SendTo("/topic/messages") // everyone subscribed to this receives
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // broadcast message
    }
}

