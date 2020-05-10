package com.spring.planner.security;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.spring.planner.service.ProfessorService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	ProfessorService professorService;
//	@Autowired
//    private AccessDeniedHandler accessDeniedHandler;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(professorService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
		http.csrf()
      .disable()
      .exceptionHandling()
      .authenticationEntryPoint(new Http403ForbiddenEntryPoint() {
      })
      .and()
      .authenticationProvider(getProvider())
      .formLogin()
      .loginProcessingUrl("/login")
      .successHandler(new AuthentificationLoginSuccessHandler())
      .failureHandler(new SimpleUrlAuthenticationFailureHandler())
      .and()
      .logout()
      .logoutUrl("/logout")
      .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
      .invalidateHttpSession(true)
      .and()
    //avec basic authentication
      .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
      .and().httpBasic();
		
//		http.csrf()
//        .disable()
//        .exceptionHandling()
//        .authenticationEntryPoint(new Http403ForbiddenEntryPoint() {
//        })
//        .and()
//        .authenticationProvider(getProvider())
//        .formLogin()
//        .loginProcessingUrl("/login")
//        .successHandler(new AuthentificationLoginSuccessHandler())
//        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//        .and()
//        .logout()
//        .logoutUrl("/logout")
//        .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
//        .invalidateHttpSession(true)
//        .and()
//        .authorizeRequests()
		//avec authentication via l'url /login
//        .antMatchers("/login").permitAll()
//        .antMatchers("/logout").permitAll()
//        .antMatchers("/**").authenticated()
//        .anyRequest().permitAll();
	}
	
	
	 private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	        @Override
	        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	            response.setStatus(HttpServletResponse.SC_OK);
	        }
	    }
	    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	        @Override
	        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
	                                    Authentication authentication) throws IOException, ServletException {
	            response.setStatus(HttpServletResponse.SC_OK);
	        }
	    }
	    @Bean
	    public AuthenticationProvider getProvider() {
	        AppAuthProvider provider = new AppAuthProvider();
	        provider.setUserDetailsService(professorService);
	        return provider;
	    }

	
	
}