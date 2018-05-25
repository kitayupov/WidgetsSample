package com.kbnt.qam.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NameValidatorTest {

    private NameValidator nameValidator;

    public NameValidatorTest() {
        nameValidator = new NameValidator();
    }

    @Test
    public void nameValidator_CorrectName_ReturnsTrue() {
        assertTrue(nameValidator.isValidName("Name"));
    }

    @Test
    public void nameValidator_EmptyName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName(""));
    }

    @Test
    public void nameValidator_SingleLetterName_ReturnsTrue() {
        assertTrue(nameValidator.isValidName("A"));
    }

    @Test
    public void nameValidator_SingleNumberName_ReturnsTrue() {
        assertTrue(nameValidator.isValidName("1"));
    }

    @Test
    public void nameValidator_SingleUnderscoreName_ReturnsTrue() {
        assertTrue(nameValidator.isValidName("_"));
    }

    @Test
    public void nameValidator_SingleSpaceName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName(" "));
    }

    @Test
    public void nameValidator_SingleLetterSingleSpaceName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName("A "));
    }

    @Test
    public void nameValidator_SingleNumberSingleSpaceName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName("1 "));
    }

    @Test
    public void nameValidator_SingleUnderscoreSingleSpaceName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName("_ "));
    }

    @Test
    public void nameValidator_SingleSpaceSingleLetterName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName(" A"));
    }

    @Test
    public void nameValidator_SingleSpaceSingleNumberName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName(" 1"));
    }

    @Test
    public void nameValidator_SingleSpaceSingleUnderscoreName_ReturnsFalse() {
        assertFalse(nameValidator.isValidName(" _"));
    }
}