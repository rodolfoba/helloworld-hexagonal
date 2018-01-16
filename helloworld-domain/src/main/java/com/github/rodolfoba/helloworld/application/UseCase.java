package com.github.rodolfoba.helloworld.application;

public interface UseCase<V, T> {

    public T execute(V command);
    
}
