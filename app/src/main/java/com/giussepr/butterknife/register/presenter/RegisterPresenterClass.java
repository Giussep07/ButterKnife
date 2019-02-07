package com.giussepr.butterknife.register.presenter;

import android.util.Patterns;

import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.register.model.RegisterModel;
import com.giussepr.butterknife.register.view.RegisterActivity;
import com.giussepr.butterknife.register.view.RegisterView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_EMPTY;
import static com.giussepr.butterknife.root.Constants.INPUT_ERROR_EMAIL_INVALID_FORMAT;

public class RegisterPresenterClass implements RegisterPresenter {

    @Nullable
    private RegisterView view;
    private RegisterModel model;

    CompositeDisposable disposable;

    @Inject
    public RegisterPresenterClass(RegisterModel model) {
        this.model = model;
    }

    @Override
    public void setView(RegisterView view) {
        this.view = view;
    }

    @Override
    public void backButtonPressed() {
        if (view != null) {
            view.goToLoginView();
        }
    }

    @Override
    public void registerButtonPressed() {
        if (view != null) {

            view.resetFieldsErrors();

            if (view.getDisplayName() == null || view.getDisplayName().trim().equals("")) {
                view.showDisplayNameError();
            } else if (view.getEmail().trim().equals("")) {
                view.showEmailError(INPUT_ERROR_EMAIL_EMPTY);
            } else if (!Patterns.EMAIL_ADDRESS.matcher(view.getEmail()).matches()) {
                view.showEmailError(INPUT_ERROR_EMAIL_INVALID_FORMAT);
            } else if (view.getPassword().equals("")) {
                view.showPasswordError();
            } else if (view.getConfirmPass().equals("")) {
                view.showConfirmPasswordError();
            } else if (!view.getPassword().equals(view.getConfirmPass())) {
                view.showPasswordsNotMatch();
            } else {
                disposable = new CompositeDisposable();
                view.disableUIElements();

                User user = new User();
                user.setDisplayName(view.getDisplayName());
                user.setEmail(view.getEmail());
                user.setPassword(view.getPassword());

                //Check if user exists

                disposable.add(model.checkUserEmailExist(user)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                user1 -> {
                                    if (user1.email != null && user1.email.equals(user.getEmail())) {
                                        view.showEmailExist();
                                    } else if (user1.displayName != null && user1.displayName.equals(user.getDisplayName())) {
                                        view.showDisplayNameExist();
                                    }
                                    view.enableUIElements();
                                },
                                Throwable::printStackTrace,
                                () -> disposable.add(model.createUser(user)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(
                                                () -> view.userCreatedSuccessfully(),
                                                throwable -> {
                                                    view.userNotCreated();
                                                    view.enableUIElements();
                                                    throwable.printStackTrace();
                                                }))));

            }
        }
    }
}
