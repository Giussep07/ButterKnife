package com.giussepr.butterknife.dataSource.local;

import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.dataSource.local.User.UserDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LocalDataSource extends RoomDatabase {

    public abstract UserDao getUserDao();
}
