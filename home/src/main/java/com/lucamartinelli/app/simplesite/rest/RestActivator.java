package com.lucamartinelli.app.simplesite.rest;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT", realmName = "home-realm")
@DeclareRoles({"dev", "test"})
public class RestActivator extends Application {

}
