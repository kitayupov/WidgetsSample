package com.kbnt.qam.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordLengthValidatorTest {

    private PasswordValidator passwordValidator;

    public PasswordLengthValidatorTest() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void passwordValidator_LengthZero_ReturnsFalse() {
        assertFalse(passwordValidator.isValidPassword(""));
    }

    @Test
    public void passwordValidator_LengthOne_ReturnsFalse() {
        assertFalse(passwordValidator.isValidPassword("1"));
    }

    @Test
    public void passwordValidator_LengthSeven_ReturnsFalse() {
        assertFalse(passwordValidator.isValidPassword("1234567"));
    }

    @Test
    public void passwordValidator_LengthEight_ReturnsTrue() {
        assertTrue(passwordValidator.isValidPassword("12345678"));
    }

    @Test
    public void passwordValidator_LengthNine_ReturnsTrue() {
        assertTrue(passwordValidator.isValidPassword("123456789"));
    }

    @Test
    public void passwordValidator_LengthEightWithSpaceBefore_ReturnsFalse() {
        assertFalse(passwordValidator.isValidPassword(" 12345678"));
    }

    @Test
    public void passwordValidator_LengthEightWithSpaceAfter_ReturnsFalse() {
        assertFalse(passwordValidator.isValidPassword("12345678 "));
    }
}
