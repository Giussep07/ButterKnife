package com.giussepr.butterknife.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.giussepr.butterknife.login.data.User;
import com.giussepr.butterknife.login.data.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LocalDataSource extends RoomDatabase {

    public abstract UserDao getUserDao();
}
