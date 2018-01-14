package com.github.rodolfoba.helloworld.domain;

public class Greeting {

    private final GreetingMessage message;
    private final String visitorIp;
    
    public Greeting(GreetingMessage message, String visitorIp) {
        this.message = message;
        this.visitorIp = visitorIp;
    }
    
    public String getValue() {
        return message.getText() + "  " + visitorIp;
    }
    
}
