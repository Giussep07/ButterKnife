package com.giussepr.butterknife.dataSource;

import com.giussepr.butterknife.models.EmailDisplayName;
import com.giussepr.butterknife.models.User;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class UserRepository implements UserDataSource {

    private final UserDataSource userLocalDataSource;

    @Inject
    UserRepository(UserDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public Single<User> loginUser(String email) {
        return userLocalDataSource.loginUser(email);
    }

    @Override
    public Single<User> loginUser(String email, String password) {
        return userLocalDataSource.loginUser(email, password);
    }

    @Override
    public Completable createUser(User user) {
        return userLocalDataSource.createUser(user);
    }

    @Override
    public Maybe<EmailDisplayName> checkUserExist(String email, String displayName) {

        return userLocalDataSource.checkUserExist(email, displayName)
                .map(user -> user);
    }
}
