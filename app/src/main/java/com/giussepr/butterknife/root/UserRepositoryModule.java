package com.giussepr.butterknife.root;

import android.app.Application;

import com.giussepr.butterknife.dataSource.UserDataSource;
import com.giussepr.butterknife.dataSource.local.LocalDataSource;
import com.giussepr.butterknife.dataSource.local.User.UserDao;
import com.giussepr.butterknife.dataSource.local.User.UserLocalDataSource;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class UserRepositoryModule {

    @Singleton
    @Binds
    abstract UserDataSource provideUserLocalDataSource(UserLocalDataSource dataSource);

    @Singleton
    @Provides
    static LocalDataSource provideLocalDataSource(Application context){
        return Room.databaseBuilder(context, LocalDataSource.class, "butterKnife").build();
    }

    @Singleton
    @Provides
    static UserDao provideUserDao(LocalDataSource dataSource){
        return dataSource.getUserDao();
    }
}
