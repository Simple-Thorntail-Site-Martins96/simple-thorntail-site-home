package com.lucamartinelli.app.simplesite.home.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.lucamartinelli.app.simplesite.home.ejb.ServicesEJB;
import com.lucamartinelli.app.simplesite.home.vo.Roles;
import com.lucamartinelli.app.simplesite.home.vo.ServiceVO;


@Path("/home")
@RequestScoped
public class HomeServices {
	
	@Inject
	private JsonWebToken callerPrincipal;
	
	//@EJB
	private ServicesEJB servicesEJB;
	
	@GET
	@Path("/role")
	@PermitAll
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Roles getRoles() {
		final Roles roles = new Roles();
		roles.setRoles(callerPrincipal.getGroups());
		return roles;
	}
	
	@GET
	@Path("/name")
	@PermitAll
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public String getFullName() {
		return callerPrincipal.getName();
	}

	@GET
	@Path("/services")
	@PermitAll
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public List<ServiceVO> getServices() {
		return servicesEJB.loadServices(callerPrincipal.getRawToken());
	}
}
