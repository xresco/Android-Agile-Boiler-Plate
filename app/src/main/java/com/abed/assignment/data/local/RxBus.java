package com.abed.assignment.data.local;

import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
import timber.log.Timber;

public class RxBus {
    private final Subject<Object, Object> mBusSubject = new SerializedSubject<>(PublishSubject.create());

    public <T> Subscription register(final Class<T> eventClass, Action1<T> onNext) {
        return mBusSubject
                .filter(event -> event.getClass().equals(eventClass))
                .map(obj -> (T) obj)
                .subscribe(onNext, throwable -> {
                    Timber.e(throwable);
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