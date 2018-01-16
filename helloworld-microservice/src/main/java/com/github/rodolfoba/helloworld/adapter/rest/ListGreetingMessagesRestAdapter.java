package com.github.rodolfoba.helloworld.adapter.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.rodolfoba.helloworld.adapter.rest.config.RestAdapterConstants;
import com.github.rodolfoba.helloworld.application.GreetingApplicationFactory;
import com.github.rodolfoba.helloworld.application.ListGreetingMessagesUseCase;
import com.github.rodolfoba.helloworld.domain.Visitor;

@Path(RestAdapterConstants.PATH)
@RequestScoped
public class ListGreetingMessagesRestAdapter {

    private String requestIP;
    private String requestUserAgent;

    @Inject
    private GreetingApplicationFactory factory;

    @Path("messages")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listMessages(@Context HttpServletRequest request) {
        ListGreetingMessagesUseCase useCase = factory.createListGreetingMessagesUseCase();
        requestIP = request.getRemoteAddr();
        requestUserAgent = request.getHeader("User-Agent");
        return useCase.execute(this.new ListGreetingMessagesUseCaseInput());
    }

    class ListGreetingMessagesUseCaseInput implements ListGreetingMessagesUseCase.Input {

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