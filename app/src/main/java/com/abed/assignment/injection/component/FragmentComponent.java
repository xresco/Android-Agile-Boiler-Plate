package com.abed.assignment.injection.component;

import com.abed.assignment.injection.PerActivity;
import com.abed.assignment.injection.module.FragmentModule;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {


}
