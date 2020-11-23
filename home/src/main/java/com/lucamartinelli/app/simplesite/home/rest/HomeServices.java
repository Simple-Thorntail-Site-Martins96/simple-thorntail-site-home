package com.lucamartinelli.app.simplesite.home.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.lucamartinelli.app.simplesite.commons.home.HomeServiceInterface;
import com.lucamartinelli.app.simplesite.commons.home.vo.Roles;
import com.lucamartinelli.app.simplesite.commons.home.vo.ServiceVO;
import com.lucamartinelli.app.simplesite.home.ejb.ServicesEJB;


@RequestScoped
public class HomeServices implements HomeServiceInterface {
	
	@Inject
	private JsonWebToken callerPrincipal;
	
	@EJB
	private ServicesEJB servicesEJB;
	
	public Roles getRoles() {
		final Roles roles = new Roles();
		roles.setRoles(callerPrincipal.getGroups());
		return roles;
	}
	
	public String getFullName() {
		return callerPrincipal.getName();
	}

	public List<ServiceVO> getServices() {
		return servicesEJB.loadServices(callerPrincipal.getRawToken());
	}
}
