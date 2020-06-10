package com.lucamartinelli.app.simplesite.rest;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.lucamartinelli.app.simplesite.vo.Roles;


@Path("/home")
@RequestScoped
public class HomeServices {
	
	@Inject
	private JsonWebToken callerPrincipal;
	
	@GET
	@Path("/role")
	@RolesAllowed({"dev", "test"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Roles getRoles() {
		final Roles roles = new Roles();
		roles.setRoles(callerPrincipal.getGroups());
		return roles;
	}
	
	@GET
	@Path("/name")
	@RolesAllowed({"dev", "test"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public String getFullName() {
		return callerPrincipal.getName();
	}
}
