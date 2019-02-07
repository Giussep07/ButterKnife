package com.giussepr.butterknife.login.presenter;

import android.util.Patterns;

import com.giussepr.butterknife.login.model.LoginModel;
import com.giussepr.butterknife.login.view.LoginView;
import com.giussepr.butterknife.models.User;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_EMPTY;
import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_INVALID_FORMAT;

public class LoginPresenterClass implements LoginPresenter {

    @Nullable
    private LoginView view;
    private LoginModel model;

    @Inject
    public LoginPresenterClass(LoginModel model) {
        this.model = model;
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {

            view.resetFieldsErrors();

            if (view.getEmail().trim().equals("")) {
                view.showEmailError(INPUT_ERROR_EMAIL_EMPTY);
            } else if (!Patterns.EMAIL_ADDRESS.matcher(view.getEmail()).matches()) {
                view.showEmailError(INPUT_ERROR_EMAIL_INVALID_FORMAT);
            } else if (view.getPassword().equals("")) {
                view.showPasswordError();
            } else {

                view.disableUIElements();
                view.showProgress();

                String email = view.getEmail();
                String password = view.getPassword();

                CompositeDisposable disposable = new CompositeDisposable();

                disposable.add(model.loginUser(email)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                user ->
                                        disposable.add(model.loginUser(email, password)
                                                .subscribeOn(Schedulers.io())
                                                .observeOn(AndroidSchedulers.mainThread())
                                                .subscribe(
                                                        user1 -> {
                                                            view.hideProgress();
                                                            view.enableUIElements();
                                                            view.loginSuccess(user1);
                                                        },
                                                        throwable -> {
                                                            view.enableUIElements();
                                                            view.hideProgress();
                                                            view.showPasswordIncorrect();
                                                            throwable.printStackTrace();
                                                        })),
                                throwable -> {
                                    view.enableUIElements();
                                    view.hideProgress();
                                    view.showUserNotExist();
                                    throwable.printStackTrace();
                                }));
            }
        }
    }

    @Override
    public User getRememberedUser() {
        return null;
    }

    @Override
    public void registerButtonClicked() {
        if (view != null) {
            view.openRegisterActivity();
        }
    }
}
