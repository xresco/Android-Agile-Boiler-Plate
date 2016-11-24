package com.abed.assignment.injection.component;

import com.abed.assignment.injection.module.ApplicationModule;
import com.abed.assignment.injection.module.ReleaseModule;
import com.abed.assignment.injection.module.TestBaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, TestBaseModule.class, ReleaseModule.class})
public interface TestApplicationComponent extends ApplicationComponent {


}
