package com.abed.assignment.injection.component;

import com.abed.assignment.injection.PerActivity;
import com.abed.assignment.injection.module.ActivityModule;
import com.abed.assignment.ui.history.HistoryActivity;
import com.abed.assignment.ui.main.MainActivity;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(HistoryActivity historyActivity);

}
