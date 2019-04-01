package com.giussepr.butterknife.dataSource.local.User;

import com.giussepr.butterknife.models.EmailDisplayName;
import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.dataSource.UserDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class UserLocalDataSource implements UserDataSource {

    private UserDao userDao;

    @Inject
    public UserLocalDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Single<User> loginUser(String email) {
        return userDao.loginUser(email);
    }

    @Override
    public Single<User> loginUser(String email, String password) {
        return userDao.loginUser(email, password);
    }

    @Override
    public Completable createUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Maybe<EmailDisplayName> checkUserExist(String email, String displayName) {
        return userDao.checkUserEmailExist(email, displayName);
    }
}
