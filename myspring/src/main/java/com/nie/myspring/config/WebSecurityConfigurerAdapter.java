package com.nie.myspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nie.myspring.repository.ReaderRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerAdapter {

	@Autowired
	private ReaderRepository readerRepository;
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/")
		.access("hasRole('')")
		.antMatchers("/**")
		.permitAll().and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("login?error=true");
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
		auth.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return  readerRepository.findOne(username);
			}
		});
	}
}
