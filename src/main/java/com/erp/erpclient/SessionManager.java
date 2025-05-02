package com.erp.erpclient;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private static final String AUTH_COOKIE_KEY = "AUTH_COOKIE";

    @Autowired
    private HttpSession httpSession;

    /**
     * Stores the authentication cookie in the session
     */
    public void setAuthCookie(String cookie) {
        httpSession.setAttribute(AUTH_COOKIE_KEY, cookie);
    }

    /**
     * Retrieves the authentication cookie from the session
     */
    public String getAuthCookie() {
        return (String) httpSession.getAttribute(AUTH_COOKIE_KEY);
    }

    /**
     * Clears the authentication cookie from the session
     */
    public void clearAuthCookie() {
        httpSession.removeAttribute(AUTH_COOKIE_KEY);
    }

    /**
     * Checks if an authentication cookie exists
     */
    public boolean hasAuthCookie() {
        return httpSession.getAttribute(AUTH_COOKIE_KEY) != null;
    }
}