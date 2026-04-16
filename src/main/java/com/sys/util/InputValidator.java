package com.sys.util;

import java.util.regex.Pattern;

/**
 * Utility for basic input validation.
 */
public class InputValidator {
    
    // Regular expression for email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates email format.
     */
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates phone number (basic check for 10-15 digits).
     */
    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        // Allows digits, spaces, and Optional '+' at the start
        String cleaned = phone.replaceAll("[\\s-]", "");
        return cleaned.matches("^\\+?[0-9]{10,15}$");
    }

    /**
     * Validates non-empty string.
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
