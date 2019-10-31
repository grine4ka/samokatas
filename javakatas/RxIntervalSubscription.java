package javakatas;

import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class RxIntervalSubscription {

    public static void main(String[] args) {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
        interval.subscribe(s -> System.out.println("Item received " + s + " on " + Thread.currentThread().getName()));

        sleep(5000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
