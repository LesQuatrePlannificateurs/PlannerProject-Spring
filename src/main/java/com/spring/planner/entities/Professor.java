package com.spring.planner.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="professor")
public class Professor extends Person implements Serializable, UserDetails{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long professorId;

    public Professor() {
        super();
    }
    
    public Professor(Professor professor) {
    	this.professorId = professor.getProfessorId();
    	this.login = professor.getLogin();
    	this.password = professor.getPassword();
    	this.firstname = professor.getFirstname();
    	this.lastname = professor.getLastname();
    	}
    

    public Professor(String login, String psw, String firstname, String lastname){
        super(login,psw,firstname,lastname);
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getFirstname() {
		// TODO Auto-generated method stub
		return super.getFirstname();
	}

	@Override
	public void setFirstname(String firstname) {
		// TODO Auto-generated method stub
		super.setFirstname(firstname);
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return super.getLastname();
	}

	@Override
	public void setLastname(String lastname) {
		// TODO Auto-generated method stub
		super.setLastname(lastname);
	}

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return super.getRole();
	}

	@Override
	public void setRole(String role) {
		// TODO Auto-generated method stub
		super.setRole(role);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

	
}
