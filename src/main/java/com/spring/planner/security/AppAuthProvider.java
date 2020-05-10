package com.spring.planner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


import com.spring.planner.service.ProfessorService;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {
	
	@Autowired
	ProfessorService professorService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
//		 String name = auth.getName();
//	        String password = auth.getCredentials()
//	                .toString();
//	        UserDetails user = professorService.loadUserByUsername(name);
//	        if (user == null) {
//	            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
//	        }
//	        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		 
	        String name = auth.getName();
	        String password = auth.getCredentials()
	                .toString();
	        UserDetails user = professorService.loadUserByUsername(name);
	        if (user == null) {
	            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
	        }else if (user != null) {
	        	if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
	        		return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
	        	}
	        }
//	        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
	        return null;
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
	
	
}
