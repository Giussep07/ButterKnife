package com.giussepr.butterknife.register.view;

import com.google.android.material.textfield.TextInputLayout;

public interface RegisterView {
    void goToLoginView();

    String getDisplayName();

    String getEmail();

    String getPassword();

    String getConfirmPass();

    void showDisplayNameError();

    void showEmailError(int error);

    void showPasswordError();

    void showConfirmPasswordError();

    void showPasswordsNotMatch();

    void userCreatedSuccessfully();

    void userNotCreated();

    void resetFieldsErrors();

    void showDisplayNameExist();

    void showEmailExist();

    void disableUIElements();

    void enableUIElements();
}
