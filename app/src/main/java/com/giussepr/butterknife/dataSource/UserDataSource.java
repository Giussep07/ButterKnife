package com.giussepr.butterknife.dataSource;

import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.models.EmailDisplayName;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface UserDataSource {

    Single<User> loginUser(String email);

    Single<User> loginUser(String email, String password);

    Completable createUser(User user);

    Maybe<EmailDisplayName> checkUserExist(String email, String displayName);
}
