package com.github.rodolfoba.helloworld.application;

import java.time.LocalDateTime;

import com.github.rodolfoba.helloworld.domain.Visitor;

public interface ListGreetingMessagesCommand {

    public Visitor getVisitor();
    public LocalDateTime getVisitTime();
    
}
