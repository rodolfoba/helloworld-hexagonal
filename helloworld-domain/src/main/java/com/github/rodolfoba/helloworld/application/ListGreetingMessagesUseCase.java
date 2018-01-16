package com.github.rodolfoba.helloworld.application;

import java.util.ArrayList;
import java.util.List;

import com.github.rodolfoba.helloworld.domain.GreetingMessage;
import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class ListGreetingMessagesUseCase implements UseCase<ListGreetingMessagesCommand, List<String>> {

    private final GreetingRepository repository;
    private final LoggingService loggingService;

    public ListGreetingMessagesUseCase(Config config) {
        this.repository = config.greetingRepository;
        this.loggingService = config.loggingService;
    }

    @Override
    public List<String> execute(ListGreetingMessagesCommand command) {
        loggingService.log("Executing " + this.getClass().getSimpleName());
        List<String> messages = new ArrayList<>();
        for (GreetingMessage message : repository.findAllMessages()) {
            messages.add(message.getText());
        }

        return messages;
    }

    public static class Config {
        public GreetingRepository greetingRepository;
        public LoggingService loggingService;
    }

}
