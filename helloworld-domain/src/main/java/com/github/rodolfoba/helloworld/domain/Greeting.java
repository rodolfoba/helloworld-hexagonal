package com.github.rodolfoba.helloworld.domain;

public class Greeting {

    private final GreetingMessage message;
    private final Visitor visitor;

    public Greeting(GreetingMessage message, Visitor visitor) {
        this.message = message;
        this.visitor = visitor;
    }

    public String getValue() {
        return message.getText() + "  " + visitor.getIp();
    }
    
    public GreetingMessage getMessage() {
        return message;
    }
    
    public Visitor getVisitor() {
        return visitor;
    }

}
