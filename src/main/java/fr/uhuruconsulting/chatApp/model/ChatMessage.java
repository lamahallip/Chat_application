package fr.uhuruconsulting.chatApp.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {

    private MessageType type;

    private String sender;

    private String content;

    public enum MessageType {
        JOIN,
        CHAT,
        LEAVE
    }

}
