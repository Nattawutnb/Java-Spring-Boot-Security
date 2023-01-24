package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("User")
				.password(passwordEncoder().encode("user"))
				.roles("USER")
				.and()
				.withUser("Admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().and().authorizeRequests()
				.antMatchers("/employee/addemp", "/employee/delete/{id}", "/employee/update/{id}").hasRole("USER")
				.antMatchers("/data/company", "/department/adddpm", "/department/delete/{id}", "/department/update/{_id}",
						 	 "/employee/name").hasRole("ADMIN")
				.antMatchers("/employee/groupAdd", "/employee/findAll", "/department/findAll")
				.anonymous().anyRequest().authenticated();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
