package ru.bykov.javakatas;

import rx.Observable;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class ConnectableObservableTest {

    public static void main(String[] args) {
        ConnectableObservable<String> publish = connectableObservable().publish();
        publish.subscribe(result -> System.out.println("Subscriber 1 Received string " + result));
        publish.subscribe(result -> System.out.println("Subscriber 2 Received string " + result));

        publish.connect();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publish.subscribe(result -> System.out.println("Subscriber 3 Received string " + result));
    }

    private static Observable<String> connectableObservable() {
        return Observable.fromCallable(() -> "String 1")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .doOnCompleted(() -> System.out.println("onCompleted"))
                .doOnNext(s -> System.out.println("onNext"))
                .doOnSubscribe(() -> System.out.println("onSubscribe"))
                .doOnUnsubscribe(() -> System.out.println("onUnsubscribe"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate"));
    }

    private static Observable<String> remote() {
        return Observable.fromCallable(() -> "remote string");
    }

    private static Observable<String> local() {
        return Observable.fromCallable(() -> "local string");
    }
}
