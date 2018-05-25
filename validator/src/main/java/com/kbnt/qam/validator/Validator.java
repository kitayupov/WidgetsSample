package com.kbnt.qam.validator;

/**
 * Base class for validators
 */
class Validator {

    static boolean isTextEmpty(String text) {
        return "".equals(text);
    }

    static boolean isTextContainsUnacceptableSymbols(String text) {
        return !text.matches("[\\w]*");
    }

    static boolean isTextLengthTooShort(String text, int length) {
        return text.length() < length;
    }

}
