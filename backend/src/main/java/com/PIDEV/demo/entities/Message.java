package com.PIDEV.demo.entities;

import lombok.Data;

@Data
public class Message {


    private MessageType type;
    private String message;
    private String room;

    public Message() {
    }

    public Message(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public enum MessageType {
        SERVER, CLIENT

    }
}
