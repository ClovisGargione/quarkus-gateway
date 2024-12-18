package com.github.clovisgargione.adapters.in.controller;

import com.github.clovisgargione.adapters.in.controller.request.UserRequest;
import com.github.clovisgargione.adapters.out.service.UserService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/users")
public class UserController {

	@Inject
	private UserService userService;
	
	@POST
	@RolesAllowed({"admin"})
	public Response createUser(UserRequest userRequest) {
		return Response.ok(userService.createUser(userRequest).getEntity(), MediaType.APPLICATION_JSON).build();
		
	}
	
	@GET
	@RolesAllowed({"user"})
	public Response listAllUsers() {
		return Response.ok(userService.listAllUsers().getEntity(), MediaType.APPLICATION_JSON ).build();
	}
	
	@DELETE
	@Path("{id}")
	@RolesAllowed({"admin"})
    public Response deleteUser(@PathParam("id") Long id) {
	   return Response.ok(userService.deleteUser(id).getEntity(), MediaType.APPLICATION_JSON).build();
    }
	
	@PUT
	@Path("{id}")
	@RolesAllowed({"admin"})
	public Response updateUser(@PathParam("id") Long id, UserRequest userRequest) {
		return Response.ok(userService.updateUser(id, userRequest).getEntity(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{id}")
	@RolesAllowed({"user"})
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(userService.findByIdUser(id).getEntity(), MediaType.APPLICATION_JSON).build();
				
	}
	
	@GET
	@Path("host")
	@RolesAllowed({"user"})
	public Response getHost() {
		return Response.ok(userService.getHost().getEntity(), MediaType.APPLICATION_JSON).build();
	}
}
