package com.anton.project.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Anton on 17.02.16.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
