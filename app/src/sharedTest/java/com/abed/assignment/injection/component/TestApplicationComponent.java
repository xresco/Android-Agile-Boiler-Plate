package com.abed.assignment.injection.component;

import com.abed.assignment.injection.module.TestApplicationModule;
import com.abed.assignment.injection.module.TestBaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestApplicationModule.class, TestBaseModule.class})
public interface TestApplicationComponent extends ApplicationComponent {


}
