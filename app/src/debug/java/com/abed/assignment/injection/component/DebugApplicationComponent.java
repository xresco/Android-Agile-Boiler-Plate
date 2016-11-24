package com.abed.assignment.injection.component;

import com.abed.assignment.injection.module.ApplicationModule;
import com.abed.assignment.injection.module.BaseModule;
import com.abed.assignment.injection.module.DebugModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, BaseModule.class, DebugModule.class})
public interface DebugApplicationComponent extends ApplicationComponent {


}
