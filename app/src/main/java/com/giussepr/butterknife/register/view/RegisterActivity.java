package com.giussepr.butterknife.register.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.giussepr.butterknife.R;
import com.giussepr.butterknife.register.presenter.RegisterPresenter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_EMPTY;
import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_INVALID_FORMAT;

public class RegisterActivity extends DaggerAppCompatActivity implements RegisterView {

    @Inject
    RegisterPresenter presenter;

    @BindView(R.id.imgButtonBack)
    ImageButton imgButtonBack;
    @BindView(R.id.textInputDisplayName)
    TextInputLayout textInputDisplayName;
    @BindView(R.id.textInputEmail)
    TextInputLayout textInputEmail;
    @BindView(R.id.textInputPassword)
    TextInputLayout textInputPassword;
    @BindView(R.id.textInputConfirmPassword)
    TextInputLayout textInputConfirmPassword;
    @BindView(R.id.buttonRegister)
    MaterialButton buttonRegister;
    @BindString(R.string.empty_field)
    String msgEmptyField;
    @BindString(R.string.invalid_email_format)
    String msgInvalidEmailFormat;
    @BindString(R.string.user_create_error)
    String msgErrorCreatingUser;
    @BindString(R.string.user_created_successfully)
    String msgUserCreatedSuccess;
    @BindString(R.string.displayName_already_exist)
    String msgDisplayNameAlreadyExist;
    @BindString(R.string.email_already_exist)
    String msgEmailAlreadyExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @OnClick({R.id.imgButtonBack, R.id.buttonRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgButtonBack:
                presenter.backButtonPressed();
                break;
            case R.id.buttonRegister:
                presenter.registerButtonPressed();
                break;
        }
    }

    //region RegisterView implementation
    @Override
    public void goToLoginView() {
        onBackPressed();
    }

    @Override
    public String getDisplayName() {
        return textInputDisplayName.getEditText().getText().toString();
    }

    @Override
    public String getEmail() {
        return textInputEmail.getEditText().getText().toString();
    }

    @Override
    public String getPassword() {
        return textInputPassword.getEditText().getText().toString();
    }

    @Override
    public String getConfirmPass() {
        return textInputConfirmPassword.getEditText().getText().toString();
    }

    @Override
    public void showDisplayNameError() {
        textInputDisplayName.setError(msgEmptyField);
        textInputDisplayName.requestFocus();
    }

    @Override
    public void showEmailError(int error) {
        switch (error) {
            case INPUT_ERROR_EMAIL_INVALID_FORMAT:
                textInputEmail.setError(msgInvalidEmailFormat);
                break;
            case INPUT_ERROR_EMAIL_EMPTY:
                textInputEmail.setError(msgEmptyField);
                break;
            default:
                break;
        }

        textInputEmail.requestFocus();
    }

    @Override
    public void showPasswordError() {
        textInputPassword.setError(msgEmptyField);
        textInputPassword.requestFocus();
    }

    @Override
    public void showConfirmPasswordError() {
        textInputConfirmPassword.setError(msgEmptyField);
        textInputConfirmPassword.requestFocus();
    }

    @Override
    public void showPasswordsNotMatch() {
        Toast.makeText(this, "The passwords not match.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void userCreatedSuccessfully() {
        Toast.makeText(this, msgUserCreatedSuccess, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void userNotCreated() {
        Toast.makeText(this, msgErrorCreatingUser, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resetFieldsErrors() {
        textInputDisplayName.setError(null);
        textInputEmail.setError(null);
        textInputPassword.setError(null);
        textInputConfirmPassword.setError(null);
    }

    @Override
    public void showDisplayNameExist() {
        textInputDisplayName.setError(msgDisplayNameAlreadyExist);
        textInputDisplayName.requestFocus();
    }

    @Override
    public void showEmailExist() {
        textInputEmail.setError(msgEmailAlreadyExist);
        textInputEmail.requestFocus();
    }

    @Override
    public void disableUIElements() {
        textInputDisplayName.setEnabled(false);
        textInputEmail.setEnabled(false);
        textInputPassword.setEnabled(false);
        textInputConfirmPassword.setEnabled(false);

        buttonRegister.setEnabled(false);
    }

    @Override
    public void enableUIElements() {
        textInputDisplayName.setEnabled(true);
        textInputEmail.setEnabled(true);
        textInputPassword.setEnabled(true);
        textInputConfirmPassword.setEnabled(true);

        buttonRegister.setEnabled(true);
    }

    //endregion
}
