package ru.bykov.javakatas;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Actions;
import rx.internal.util.ActionSubscriber;
import rx.schedulers.Schedulers;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class SubscribersReuse {

    public static void main(String[] args) {
        Subscriber<String> subscriber = new ActionSubscriber<>(
                string -> System.out.println("Received string " + string + " on thread " + Thread.currentThread().getName()),
                throwable -> System.out.println(throwable.getMessage()),
                Actions.empty());

        Observable<String> first = Observable.fromCallable(() -> "First string");
        first.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(subscriber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Observable<String> second = Observable.fromCallable(() -> "Second string");
        second.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(subscriber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
