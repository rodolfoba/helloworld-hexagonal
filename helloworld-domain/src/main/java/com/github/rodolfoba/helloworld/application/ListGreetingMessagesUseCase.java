package com.github.rodolfoba.helloworld.application;

import java.util.ArrayList;
import java.util.List;

import com.github.rodolfoba.helloworld.domain.GreetingMessage;
import com.github.rodolfoba.helloworld.domain.GreetingRepository;

public class ListGreetingMessagesUseCase implements UseCase<List<String>> {

    private final GreetingRepository repository;
    
    public ListGreetingMessagesUseCase(Config config) {
        super();
        this.repository = config.greetingRepository;
    }
    
    @Override
    public List<String> execute() {
        List<String> messages = new ArrayList<>();
        for (GreetingMessage message : repository.findAllMessages()) {
            messages.add(message.getText());
        }
        
        return messages;
    }
    
    public static class Config {

        public GreetingRepository greetingRepository;

    }

}
