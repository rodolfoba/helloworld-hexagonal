package com.github.rodolfoba.helloworld.domain;

public class GreetingMessage {

    private final GreetingMessageId id;
    private final String text;
    
    public GreetingMessage(GreetingMessageId id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public GreetingMessageId getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }
    
}
