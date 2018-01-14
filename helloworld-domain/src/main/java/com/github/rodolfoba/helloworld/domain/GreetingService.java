package com.github.rodolfoba.helloworld.domain;

import java.util.List;
import java.util.Random;

public class GreetingService {

    private final GreetingRepository repository;
    
    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }
    
    public Greeting greetVisitor(String visitorIp) {
        List<GreetingMessage> messages = repository.findAllMessages();
        GreetingMessage message = messages.get(new Random().nextInt(messages.size()));
        return new Greeting(message, visitorIp);
    }
    
}