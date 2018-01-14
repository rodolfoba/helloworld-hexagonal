package com.github.rodolfoba.helloworld.domain;

import java.util.List;

public interface GreetingRepository {

    public List<GreetingMessage> findAllMessages();
    
}
