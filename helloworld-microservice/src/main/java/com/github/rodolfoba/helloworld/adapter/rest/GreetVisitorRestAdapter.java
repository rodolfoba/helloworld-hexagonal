package com.github.rodolfoba.helloworld.adapter.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.rodolfoba.helloworld.adapter.rest.config.RestAdapterConstants;
import com.github.rodolfoba.helloworld.application.GreetVisitorUseCase;
import com.github.rodolfoba.helloworld.application.GreetingApplicaton;

@Path(RestAdapterConstants.PATH)
@RequestScoped
public class GreetVisitorRestAdapter {

    @Inject
    private GreetingApplicaton application;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@Context HttpServletRequest request) {
        return application
                .greetVisitor(new GreetVisitorUseCase.Input(request.getRemoteAddr(), request.getHeader("User-Agent")));
    }
}
