package com.anbu.switchmediaexercise;

import android.app.Application;

import com.anbu.switchmediaexercise.presentation.events.RxEventBus;
import com.facebook.stetho.Stetho;

/**
 * Android Main application
 */

public class AcmeApplication extends Application {

    private static ComponentApplication componentApplication;
    private static AcmeApplication instance;
    private RxEventBus rxBus;

    @Override
    public void onCreate() {
        super.onCreate();

        componentApplication = DaggerComponentApplication.builder().build();
        instance = this;
        rxBus = new RxEventBus();
        Stetho.initializeWithDefaults(this);
    }

    public static AcmeApplication get() {
        return instance;
    }

    public RxEventBus bus() {
        return rxBus;
    }

    public static ComponentApplication component() { return componentApplication;}

}
