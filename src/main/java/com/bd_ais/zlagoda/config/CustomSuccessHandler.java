package com.bd_ais.zlagoda.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority auth : authorities) {
            String role = auth.getAuthority();
            if (role.equals("ROLE_MANAGER")) {
                response.sendRedirect("/manager");
                return;
            } else if (role.equals("ROLE_CASHIER")) {
                response.sendRedirect("/cashier");
                return;
            } else if (role.equals("ROLE_CUSTOMER")) {
                response.sendRedirect("/home");
                return;
            }
        }

        response.sendRedirect("/auth"); // fallback
    }
}

