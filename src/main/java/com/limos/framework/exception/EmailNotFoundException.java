package com.limos.framework.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author: arifaydogan
 */
public class EmailNotFoundException extends AuthenticationException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
