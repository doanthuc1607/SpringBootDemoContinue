package com.sample.administration.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        // Implement your custom authentication logic here
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        // Implement your custom post-authentication logic here
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        // Implement your custom logic on authentication failure here
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
