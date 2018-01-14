package com.github.rodolfoba.helloworld.application;

import javax.inject.Inject;

import com.github.rodolfoba.helloworld.domain.GreetingRepository;

public class GreetingApplicationFactory {

    @Inject
    private GreetingRepository greetingRepository;
    
    public ListGreetingMessagesUseCase createListGreetingMessagesUseCase() {
        ListGreetingMessagesUseCase.Config config = new ListGreetingMessagesUseCase.Config();
        config.greetingRepository = greetingRepository;
        
        return new ListGreetingMessagesUseCase(config);
    }

    public GreetVisitorUseCase createGreetVisitorUseCase() {
        GreetVisitorUseCase.Config config = new GreetVisitorUseCase.Config();
        config.greetingRepository = greetingRepository;
        return new GreetVisitorUseCase(config);
    }
}
