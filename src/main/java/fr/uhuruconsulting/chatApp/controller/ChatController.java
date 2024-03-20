package fr.uhuruconsulting.chatApp.controller;

import fr.uhuruconsulting.chatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


import java.util.Objects;

@Controller
public class ChatController {

    @MessageMapping(value = "/chat.sendMessage")
    @SendTo(value = "/topic/public")
    public ChatMessage sendMesseage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping(value = "/chat.adduser")
    @SendTo(value = "/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {

        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSender());

        return chatMessage;
    }
}


