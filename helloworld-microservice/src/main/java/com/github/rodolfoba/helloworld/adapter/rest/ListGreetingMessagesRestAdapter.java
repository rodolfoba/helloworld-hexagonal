package com.github.rodolfoba.helloworld.adapter.rest;

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
import com.github.rodolfoba.helloworld.application.GreetingApplicaton;
import com.github.rodolfoba.helloworld.application.ListGreetingMessagesUseCase;

@Path(RestAdapterConstants.PATH)
@RequestScoped
public class ListGreetingMessagesRestAdapter {

    @Inject
    private GreetingApplicaton application;

    @Path("messages")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listMessages(@Context HttpServletRequest request) {
        return application.listGreetingMessages(
                new ListGreetingMessagesUseCase.Input(request.getRemoteAddr(), request.getHeader("User-Agent")));
    }

}