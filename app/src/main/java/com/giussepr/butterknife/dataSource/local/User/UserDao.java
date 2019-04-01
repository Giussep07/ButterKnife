package com.giussepr.butterknife.dataSource.local.User;


import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.models.EmailDisplayName;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Insert
    Completable insertUser(User user);

    @Query("SELECT * FROM User WHERE email = :email")
    Single<User> loginUser(String email);

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    Single<User> loginUser(String email, String password);

    @Delete
    void deleteUser(User user);

    @Query("SELECT email, displayName FROM User WHERE email = :email OR displayName = :displayName")
    Maybe<EmailDisplayName> checkUserEmailExist(String email, String displayName);
}
