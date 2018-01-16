package com.github.rodolfoba.helloworld.adapter.rest;

import java.time.LocalDateTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.rodolfoba.helloworld.application.GreetVisitorCommand;
import com.github.rodolfoba.helloworld.application.GreetVisitorUseCase;
import com.github.rodolfoba.helloworld.application.GreetingApplicationFactory;
import com.github.rodolfoba.helloworld.domain.Visitor;

@Path(RestAdapterConstants.PATH)
@RequestScoped
public class GreetVisitorRestAdapter {

    @Inject
    private GreetingApplicationFactory factory;

    private String requestIP;
    private String requestUserAgent;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@Context HttpServletRequest request) {
        GreetVisitorUseCase useCase = factory.createGreetVisitorUseCase();
        requestIP = request.getRemoteAddr();
        requestUserAgent = request.getHeader("User-Agent");
        return useCase.execute(this.new Command());
    }

    class Command implements GreetVisitorCommand {

        @Override
        public Visitor getVisitor() {
            return new Visitor(requestIP, requestUserAgent);
        }

        @Override
        public LocalDateTime getVisitTime() {
            return LocalDateTime.now();
        }
    }
}
