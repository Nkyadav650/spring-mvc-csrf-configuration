package com.csrf1.tokenrepo;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

public class CustomCsrfTokenRepository implements CsrfTokenRepository {
	@Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String token = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        // Save the token in the session or wherever you need to store it
        request.getSession().setAttribute("_csrf", token);
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        // Load the token from the session or wherever it was stored
        Object token = request.getSession().getAttribute("_csrf");
        if (token == null) {
            return null;
        }
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.toString());
    }


}
