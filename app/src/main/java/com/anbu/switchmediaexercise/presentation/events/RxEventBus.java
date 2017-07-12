package com.anbu.switchmediaexercise.presentation.events;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Rx Event Bus to capture the Events raised in the app
 */
public class RxEventBus {

    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public RxEventBus() {}

    public void post(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return bus;
    }

}