package com.spring.planner.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements Serializable {

	private String login;
	private String password;
	
	public MyUserPrincipal() {
	}
	
	public MyUserPrincipal(String login, String password) {
		this.login = login;
		this.password=password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
