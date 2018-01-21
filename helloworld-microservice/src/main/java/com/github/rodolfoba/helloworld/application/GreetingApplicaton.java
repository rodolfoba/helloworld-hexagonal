package com.github.rodolfoba.helloworld.application;

import java.util.List;

import javax.inject.Inject;

import com.github.rodolfoba.helloworld.domain.GreetingRepository;
import com.github.rodolfoba.helloworld.infrastructure.audit.Audit;
import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class GreetingApplicaton {

    @Inject
    private GreetingRepository greetingRepository;

    @Inject
    private LoggingService loggingService;
    
    @Audit
    public String greetVisitor(GreetVisitorUseCase.Input input) {
        GreetVisitorUseCase.Config config = new GreetVisitorUseCase.Config();
        config.greetingRepository = greetingRepository;
        config.loggingService = loggingService;
        
        GreetVisitorUseCase useCase = new GreetVisitorUseCase(config);
        return useCase.execute(input);
    }
    
    @Audit
    public List<String> listGreetingMessages(ListGreetingMessagesUseCase.Input input) {
        ListGreetingMessagesUseCase.Config config = new ListGreetingMessagesUseCase.Config();
        config.greetingRepository = greetingRepository;
        config.loggingService = loggingService;
        
        ListGreetingMessagesUseCase useCase = new ListGreetingMessagesUseCase(config);
        return useCase.execute(input);
    }
    
}
