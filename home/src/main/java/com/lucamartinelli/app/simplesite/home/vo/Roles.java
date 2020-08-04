package com.lucamartinelli.app.simplesite.home.vo;

import java.util.Arrays;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Roles {
	
	private Set<String> roles;

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		if (this.roles == null) 
			return Arrays.toString(new String[0]);
		return Arrays.toString(roles.toArray(new String[0]));
	}
	
}
