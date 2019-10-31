package javakatas;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class ObservableCache {

    public static void main(String[] args) {
        Observable<String> cached = Observable.fromCallable(() -> {
            System.out.println("some long operation for retrieving a string " + Thread.currentThread().getName());
            return "Some string";
        }).cache();
        cached.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
                .doOnUnsubscribe(() -> System.out.println("un subscribed"))
                .subscribe(string -> System.out.println("Received string " + string + " on thread " + Thread.currentThread().getName()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cached.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
                .subscribe(string -> System.out.println("Received cached string " + string + " on thread " + Thread.currentThread().getName()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
