package com.csrf1.tokenrepo;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import com.csrf1.service.CustomFilter;

public class CustomCsrfTokenRepository implements CsrfTokenRepository {
	
	
	@Autowired
	CustomFilter customFilter;
	@Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String token = UUID.randomUUID().toString();
        System.out.println("generateToken : "+token);
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token);
        
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        // Save the token in the session or wherever you need to store it
    	//customFilter.destroy();
        //request.getSession().setAttribute("_csrf", token);
        System.out.println("saveToken : ");
        
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        // Load the token from the session or wherever it was stored
    	CsrfToken csrfToken = this.generateToken(request);
    	
        String token = request.getParameter("_csrf");
       
        if (token == null) {
            return null;
        }
        System.out.println("loadToken : "+csrfToken.getToken());
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf",csrfToken.getToken());
    }


}
