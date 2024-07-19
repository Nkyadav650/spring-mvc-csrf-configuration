package com.csrf1.service;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {
    Logger logger = Logger.getLogger(CustomFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        System.out.println("request : "+request.isSecure());

        if (token != null) {
            logger.info("CSRF Token: " + token.getToken());
        }
        
        chain.doFilter(request, response);
    }

  
    @Override
    public void destroy() {
    	Filter.super.destroy();
    }
}
