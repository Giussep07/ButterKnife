package com.giussepr.butterknife.login.data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    User loginUser(String email, String password);

    @Delete
    void deleteUser(User user);
}
