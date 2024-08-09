package com.sample.administration.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlaintextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // Simply return the raw password as is
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Compare raw password with the stored password
        return rawPassword.toString().equals(encodedPassword);
    }

    // Optionally, you can make this a singleton
    public static PasswordEncoder getInstance() {
        return new PlaintextPasswordEncoder();
    }
}

