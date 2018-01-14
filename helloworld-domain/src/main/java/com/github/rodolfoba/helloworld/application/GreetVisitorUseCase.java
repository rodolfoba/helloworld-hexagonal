package com.github.rodolfoba.helloworld.application;

import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.domain.GreetingService;

public class GreetVisitorUseCase implements CommandUseCase<GreetCommand, String> {

    private final GreetingRepository repository;
    private final GreetingService service;
    
    public GreetVisitorUseCase(Config config) {
        this.repository = config.greetingRepository;
        this.service = new GreetingService(this.repository);
    }
    
    @Override
    public String execute(GreetCommand command) {
        return service.greetVisitor(command.ip).getValue();
    }
    
    public static class Config {
        public GreetingRepository greetingRepository;
    }

}
