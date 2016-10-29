package com.abed.assignment.controller;

import android.os.Handler;

import rx.*;
import rx.functions.*;
import rx.subjects.*;

public class RxBus {
    private final Subject<Object, Object> mBusSubject = new SerializedSubject<>(PublishSubject.create());
    private final Handler handler = new Handler();

    public <T> Subscription register(final Class<T> eventClass, Action1<T> onNext) {
        return mBusSubject
                .filter(event -> event.getClass().equals(eventClass))
                .map(obj -> (T) obj)
                .subscribe(onNext, throwable -> {
                    throwable.printStackTrace();
                });
    }

    public <T> Subscription register(final Class<T> eventClass, Action1<T> onNext, Action1<Throwable> onError) {
        return mBusSubject
                .filter(event -> event.getClass().equals(eventClass))
                .map(obj -> (T) obj)
                .subscribe(onNext, onError);
    }

    public void post(Object event) {
        mBusSubject.onNext(event);
    }

}