package com.kbnt.qam.validator;

import android.text.Editable;

/**
 * Validator for password fields
 */
public class PasswordValidator extends NameValidator {

    @Override
    protected boolean isValidText(Editable editable) {
        return isValidPassword(editable.toString());
    }

    boolean isValidPassword(String text) {
        boolean isValid = false;
        if (Validator.isTextLengthTooShort(text, 8)) {
            showPasswordLengthTooShort();
        } else {
            isValid = super.isValidName(text);
        }
        return isValid;
    }

    private void showPasswordLengthTooShort() {
        showEditTextError("Пароль должен содержать минимум 8 символов");
    }
}
