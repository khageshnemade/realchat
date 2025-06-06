package com.chatapp.realchat.controllers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chatapp.realchat.models.ChatMessage;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat1")
    public void send(ChatMessage message) {
        messagingTemplate.convertAndSendToUser(
            message.getReceiver().getUserId(),
            "/queue/messages",
            message
        );

        // Optional: Echo back to sender to show in their chat UI
        messagingTemplate.convertAndSendToUser(
            message.getSender().getUserId(),
            "/queue/messages",
            message
        );
    }
}
