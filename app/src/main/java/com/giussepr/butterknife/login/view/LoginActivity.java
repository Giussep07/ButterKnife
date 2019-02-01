package com.giussepr.butterknife.login.view;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.giussepr.butterknife.R;
import com.giussepr.butterknife.login.presenter.LoginPresenter;
import com.giussepr.butterknife.root.App;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.editTextEmail)
    TextInputEditText editTextEmail;
    @BindView(R.id.editTextPassword)
    TextInputEditText editTextPassword;
    @BindView(R.id.buttonLogin)
    MaterialButton buttonLogin;
    @BindView(R.id.textViewNewAccount)
    TextView textViewNewAccount;
    @BindView(R.id.checkBoxRemember)
    CheckBox checkBoxRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

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

    //region Implementation LoginView

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString();
    }

    @Override
    public void showUserNotExist() {
        Toast.makeText(this, "User not exist.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Email or password field can't be empty.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login user successful 🤘.", Toast.LENGTH_SHORT).show();
    }

    //endregion
}
