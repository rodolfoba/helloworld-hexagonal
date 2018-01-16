package com.github.rodolfoba.helloworld.application;

import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.domain.GreetingService;
import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class GreetVisitorUseCase implements UseCase<GreetVisitorCommand, String> {

    private final GreetingRepository repository;
    private final GreetingService service;
    private final LoggingService loggingService;
    
    public GreetVisitorUseCase(Config config) {
        this.repository = config.greetingRepository;
        this.loggingService = config.loggingService;
        this.service = new GreetingService(this.repository);
    }
    
    @Override
    public String execute(GreetVisitorCommand command) {
        loggingService.log("Executing " + this.getClass().getSimpleName());
        return service.greetVisitor(command.getVisitor()).getValue();
    }
    
    public static class Config {
        public GreetingRepository greetingRepository;
        public LoggingService loggingService;
    }

}
