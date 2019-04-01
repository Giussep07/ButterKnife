package com.giussepr.butterknife.register.model;

import com.giussepr.butterknife.models.EmailDisplayName;
import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.dataSource.UserRepository;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Completable;
import io.reactivex.Maybe;

public class RegisterModelClass implements RegisterModel {

    @Nullable
    private UserRepository repository;

    @Inject
    public RegisterModelClass(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<EmailDisplayName> checkUserEmailExist(User user) {
        return repository.checkUserExist(user.getEmail(), user.getDisplayName());
    }

    @Override
    public Completable createUser(User user) {
        return repository.createUser(user);
    }
}
