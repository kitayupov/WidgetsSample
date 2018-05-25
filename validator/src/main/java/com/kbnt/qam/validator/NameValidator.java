package com.kbnt.qam.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Validator for name fields
 */
public class NameValidator implements TextWatcher {

    private EditText editText;

    private boolean isValid = false;

    public NameValidator() {

    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        isValid = isValidText(editable);
    }

    protected boolean isValidText(Editable editable) {
        return isValidName(editable.toString());
    }

    boolean isValidName(String text) {
        boolean isValid = false;
        if (Validator.isTextEmpty(text)) {
            showEmptyTextError();
        } else if (Validator.isTextContainsUnacceptableSymbols(text)) {
            showUnacceptableSymbolsError();
        } else {
            isValid = true;
        }
        return isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    private void showEmptyTextError() {
        showEditTextError("Поле не может быть пустым");
    }

    private void showUnacceptableSymbolsError() {
        showEditTextError("Содержит недопустимые символы");
    }

    void showEditTextError(String error) {
        if (editText != null) {
            editText.setError(error);
        }
    }
}
