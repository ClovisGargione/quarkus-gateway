package com.github.clovisgargione.adapters.out.service;

import java.net.UnknownHostException;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.clovisgargione.adapters.in.controller.request.UserRequest;
import com.github.clovisgargione.adapters.out.client.UserRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Inject
	@RestClient
	private UserRestClient userRestClient;
	
	@Override
	public Response createUser(UserRequest userRequest) {
		return userRestClient.createUser(userRequest);
	}

	@Override
	public Response listAllUsers() {
		return userRestClient.listAllUsers();
	}

	@Override
	public Response deleteUser(Long id) {
		return userRestClient.deleteUser(id);
	}

	@Override
	public Response updateUser(Long id, UserRequest userRequest) {
		return userRestClient.updateUser(id, userRequest);
	}

	@Override
	public Response findByIdUser(Long id) {
		return userRestClient.findByIdUser(id);
	}

	@Override
	public Response getHost() {
		try {
			return userRestClient.getHost();
		} catch (UnknownHostException e) {
			logger.error(e.getMessage());
		}
		return Response.serverError().build();
	}

}
