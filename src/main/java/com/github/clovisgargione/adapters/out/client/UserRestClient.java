package com.github.clovisgargione.adapters.out.client;

import java.net.UnknownHostException;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.github.clovisgargione.adapters.in.controller.request.UserRequest;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("users")
@RegisterRestClient(baseUri = "stork://social-service")
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@RegisterClientHeaders
@ApplicationScoped
public interface UserRestClient {

	@POST
	Response createUser(UserRequest userRequest);
	
	@GET
	public Response listAllUsers();
	
	@DELETE
	@Path("{id}")
	Response deleteUser(@PathParam("id") Long id);
	
	@PUT
	@Path("{id}")
	Response updateUser(@PathParam("id") Long id, UserRequest userRequest);
	
	@GET
	@Path("{id}")
	Response findByIdUser(@PathParam("id") Long id);
	
	@GET
	@Path("host")
	Response getHost() throws UnknownHostException;
	
	
}
