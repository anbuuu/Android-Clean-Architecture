package com.anbu.switchmediaexercise.domain.interactor;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Default {@link Interactor} base class .
 */
abstract class Interactor<Result, Parameters> {

    private Subscription subscription;

    /**
     * Abstract method to implement in interactors.
     *
     * @param parameters
     * @return Result
     */
    protected abstract Observable<ArrayList<Result>> createObservable(Parameters parameters);

    /**
     * Execute interactor <em>synchronously</em>.
     *
     * @param parameters
     * @return Result
     */
    public Observable<ArrayList<Result>> execute(Parameters parameters){
        return createObservable(parameters);
    }

    /**
     * Execute interactor <em>asynchronously</em>.
     *
     * @param parameters
     * @param subscriber
     */
    public void execute(Parameters parameters, Subscriber<ArrayList<Result>> subscriber){
        subscription = createObservable(parameters)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void cancel(){
        if(subscription != null){
            subscription.unsubscribe();
        }
    }

}
