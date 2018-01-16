package com.github.rodolfoba.helloworld.adapter.logger;

import java.util.logging.Logger;

import com.github.rodolfoba.helloworld.infrastructure.logging.LoggingService;

public class ConsoleLoggerAdapter implements LoggingService {

    @Override
    public void log(String message) {
        Logger.getLogger(this.getClass().getSimpleName()).info(message);
    }

}
