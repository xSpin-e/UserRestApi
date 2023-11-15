package com.xspin.RestApi.security;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.security.config.Customizer.withDefaults;

import java.beans.JavaBean;

import lombok.RequiredArgsConstructor;



@Configuration //relacionados a objetos bean
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {
	//Diferenciamos end-points publicos y protegidos
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
	            .csrf(csrf -> 
	                csrf
	                .disable())
	            .authorizeHttpRequests(authRequest ->
	              authRequest
	                .requestMatchers("/auth/**").permitAll() //todas permitidas
	                .anyRequest().authenticated() //el resto no serán validas hasta logeo/registro
	                )
	            .formLogin(formLogin ->
                formLogin
                    .loginPage("/") // Redirige a /login para la página de inicio de sesión
                    .permitAll()
            )
            .build();
	}
}

