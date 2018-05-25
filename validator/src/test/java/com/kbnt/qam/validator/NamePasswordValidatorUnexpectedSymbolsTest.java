package com.kbnt.qam.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class NamePasswordValidatorUnexpectedSymbolsTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{
                "~", "`", "!", "@", "#", "№", "$", "%", "^", "&", "*", "(", ")", "-", "+", "=", "/",
                "{", "[", "}", "]", ":", ";", "\"", "'", "|", "\\", ">", "<", ",", ".", "?", "/"
        });
    }

    private String symbol;

    public NamePasswordValidatorUnexpectedSymbolsTest(String symbol) {
        this.symbol = symbol;
    }

    @Test
    public void nameValidator_UnexpectedSymbol_ReturnsFalse() {
        assertFalse(new NameValidator().isValidName(symbol));
    }


    @Test
    public void passwordValidator_UnexpectedSymbol_ReturnsFalse() {
        assertFalse(new PasswordValidator().isValidPassword(symbol));
    }
}
