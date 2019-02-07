package com.giussepr.butterknife.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.giussepr.butterknife.R;
import com.giussepr.butterknife.login.presenter.LoginPresenter;
import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.register.view.RegisterActivity;
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

public class LoginActivity extends DaggerAppCompatActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.textInputEmail)
    TextInputLayout textInputEmail;
    @BindView(R.id.textInputPassword)
    TextInputLayout textInputPassword;
    @BindView(R.id.buttonLogin)
    MaterialButton buttonLogin;
    @BindView(R.id.checkBoxRemember)
    CheckBox checkBoxRemember;
    @BindView(R.id.textViewRegister)
    TextView textViewRegister;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindString(R.string.empty_field)
    String msgEmptyField;
    @BindString(R.string.invalid_email_format)
    String msgInvalidEmailFormat;
    @BindString(R.string.user_not_exist)
    String msgUserNotExist;
    @BindString(R.string.password_incorrect)
    String msgIncorrectPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @OnClick(R.id.checkBoxRemember)
    public void onCheckBoxRememberClicked() {
    }

    @OnClick(R.id.buttonLogin)
    public void onButtonLoginClicked() {
        presenter.loginButtonClicked();
    }

    @OnClick(R.id.textViewRegister)
    public void onTextViewRegisterClicked() {
        presenter.registerButtonClicked();
    }

    //region Implementation LoginView

    @Override
    public String getEmail() {
        return textInputEmail.getEditText().getText().toString();
    }

    @Override
    public String getPassword() {
        return textInputPassword.getEditText().getText().toString();
    }

    @Override
    public void showUserNotExist() {
        Toast.makeText(this, msgUserNotExist, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordIncorrect() {
        Toast.makeText(this, msgIncorrectPassword, Toast.LENGTH_SHORT).show();
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
    public void loginSuccess(User user) {
        Toast.makeText(this, "Login user successful 🤘. " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void disableUIElements() {
        textInputEmail.setEnabled(false);
        textInputPassword.setEnabled(false);

        checkBoxRemember.setEnabled(false);

        buttonLogin.setEnabled(false);
        textViewRegister.setEnabled(false);
    }

    @Override
    public void enableUIElements() {
        textInputEmail.setEnabled(true);
        textInputPassword.setEnabled(true);
        checkBoxRemember.setEnabled(true);

        buttonLogin.setEnabled(true);

        textViewRegister.setEnabled(true);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void resetFieldsErrors() {
        textInputEmail.setError(null);
        textInputPassword.setError(null);
    }

    //endregion
}
