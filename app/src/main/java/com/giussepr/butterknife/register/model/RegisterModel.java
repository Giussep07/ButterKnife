package com.giussepr.butterknife.register.model;

import com.giussepr.butterknife.models.EmailDisplayName;
import com.giussepr.butterknife.models.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface RegisterModel {

    Maybe<EmailDisplayName> checkUserEmailExist(User user);

    Completable createUser(User user);
}
