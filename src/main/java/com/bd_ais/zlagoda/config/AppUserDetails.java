package com.bd_ais.zlagoda.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public AppUserDetails(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }
    @Override public String getPassword() { return password; }
    @Override public String getUsername() { return username; }

}
