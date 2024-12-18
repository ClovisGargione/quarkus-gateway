package com.github.clovisgargione.adapters.out.service;

import com.github.clovisgargione.adapters.in.controller.request.UserRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public interface UserService {

	Response createUser(UserRequest userRequest);
	
	Response listAllUsers();
	
	Response deleteUser(@PathParam("id") Long id);
	
	Response updateUser(@PathParam("id") Long id, UserRequest userRequest);
	
	Response findByIdUser(@PathParam("id") Long id);
	
	Response getHost();
}
