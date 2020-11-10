package com.lucamartinelli.app.simplesite.home.rest;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("")
@LoginConfig(authMethod = "MP-JWT", realmName = "simplesite-realm")
@DeclareRoles({"dev", "test"})
public class RestActivator extends Application {

}
