package com.app.isb_bs2.bs.rxbus;

import com.app.isb_bs2.bs.rxevent.OverTimeEvent;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by 003418 on 2017/08/15.
 */

public class RxBus {
    private static RxBus mRxBus = null;

    private Subject<Object> bus = PublishSubject.create();

    public static synchronized RxBus getInstance() {
        if (mRxBus == null) {
            mRxBus = new RxBus();
        }
        return mRxBus;
    }

    public void send(final Object event) {
        if(hasObservers()){
            bus.onNext(event);
        }
    }

    public void send(int code, String msg){
        if (hasObservers()){
            bus.onNext(new OverTimeEvent(code, msg));
        }
    }



    public Observable<Object> toObservable() {
        return bus;
    }

    public <T> Observable<T> toObservable(Class<T> eventType)
    {
        return bus.ofType(eventType);
    }



    public boolean hasObservers() {
        return bus.hasObservers();
    }

    public void unregister(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
