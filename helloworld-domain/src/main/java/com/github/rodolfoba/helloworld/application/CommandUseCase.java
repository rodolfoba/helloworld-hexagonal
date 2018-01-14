package com.github.rodolfoba.helloworld.application;

public interface CommandUseCase<V, T> {

    public T execute(V command);
    
}
