package com.saraya.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	
	public void configurationGlobalSecurity(AuthenticationManagerBuilder auth throws Exception) {
	 
		auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")
		.roles("USER", "ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
				.formLogin();
	}

}
