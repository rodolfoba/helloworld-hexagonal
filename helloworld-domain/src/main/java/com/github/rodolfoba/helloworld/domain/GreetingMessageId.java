package com.github.rodolfoba.helloworld.domain;

import java.util.UUID;

public class GreetingMessageId {

    private final UUID value;

    public GreetingMessageId(UUID id) {
        this.value = id;
    }

    public UUID getValue() {
        return value;
    }

}
