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

import com.github.rodolfoba.helloworld.application.GreetCommand;
import com.github.rodolfoba.helloworld.application.GreetVisitorUseCase;
import com.github.rodolfoba.helloworld.application.GreetingApplicationFactory;
import com.github.rodolfoba.helloworld.application.ListGreetingMessagesUseCase;

@Path("greeting")
@RequestScoped
public class GreetingRestAdapter {

    @Inject
    private GreetingApplicationFactory factory;
    
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greet(@Context HttpServletRequest request) {
		GreetVisitorUseCase useCase = factory.createGreetVisitorUseCase();
		
		GreetCommand command = new GreetCommand();
	    command.ip = request.getRemoteAddr();
		
	    return useCase.execute(command);
	}
	
	@Path("messages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> listMessages() {
	    ListGreetingMessagesUseCase useCase = factory.createListGreetingMessagesUseCase();
	    return useCase.execute();
	}
	
}