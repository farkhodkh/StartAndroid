package ru.haknazarovfarkhod.startandroid.lisson1_Lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyServer implements LifecycleObserver {
    private String TAG = "LifecycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        System.out.println("ON_START");
        Log.i(TAG, "connect: ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        System.out.println("ON_STOP");
        Log.i(TAG, "disconnect: ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(LifecycleOwner source, Lifecycle.Event event) {
        Log.i(TAG, "onAny: " + event.name());
    }
}
