package com.github.rodolfoba.helloworld.application;

import com.github.rodolfoba.helloworld.application.GreetVisitorUseCase.Input;
import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.domain.GreetingService;
import com.github.rodolfoba.helloworld.domain.Visitor;
import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class GreetVisitorUseCase implements UseCase<Input, String> {

    private final GreetingRepository repository;
    private final GreetingService service;
    private final LoggingService loggingService;

    public GreetVisitorUseCase(Config config) {
        this.repository = config.greetingRepository;
        this.loggingService = config.loggingService;
        this.service = new GreetingService(this.repository);
    }

    @Override
    public String execute(Input input) {
        loggingService.log("Executing " + this.getClass().getSimpleName());
        return service.greetVisitor(new Visitor(input.visitorIp, input.visitorUserAgent)).getValue();
    }

    public static class Config {
        public GreetingRepository greetingRepository;
        public LoggingService loggingService;
    }

    public static class Input {

        public String visitorIp;
        public String visitorUserAgent;

        public Input(String visitorIp, String visitorUserAgent) {
            this.visitorIp = visitorIp;
            this.visitorUserAgent = visitorUserAgent;
        }
    }

}
