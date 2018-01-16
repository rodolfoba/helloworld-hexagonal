package com.github.rodolfoba.helloworld.application;

import javax.inject.Inject;

import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class GreetingApplicationFactory {

    @Inject
    private GreetingRepository greetingRepository;

    @Inject
    private LoggingService loggingService;

    public ListGreetingMessagesUseCase createListGreetingMessagesUseCase() {
        ListGreetingMessagesUseCase.Config config = new ListGreetingMessagesUseCase.Config();
        config.greetingRepository = greetingRepository;
        config.loggingService = loggingService;
        return new ListGreetingMessagesUseCase(config);
    }

    public GreetVisitorUseCase createGreetVisitorUseCase() {
        GreetVisitorUseCase.Config config = new GreetVisitorUseCase.Config();
        config.greetingRepository = greetingRepository;
        config.loggingService = loggingService;
        return new GreetVisitorUseCase(config);
    }
}
