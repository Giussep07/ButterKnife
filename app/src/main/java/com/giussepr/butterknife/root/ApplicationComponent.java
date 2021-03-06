package com.giussepr.butterknife.root;

import android.app.Application;

import com.giussepr.butterknife.home.HomeModule;
import com.giussepr.butterknife.searchResult.SearchResultModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        UserRepositoryModule.class,
        HomeModule.class,
        PixabayRepositoryModule.class,
        SearchResultModule.class})
public interface ApplicationComponent extends AndroidInjector<ApplicationClass> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }

//    void inject(LoginActivity loginActivity);
//
//    void inject(RegisterActivity registerActivity);
//
//    LocalDataSource roomDataSource();
}
