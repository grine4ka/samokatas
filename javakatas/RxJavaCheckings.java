package javakatas;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class RxJavaCheckings {

    public static void main(String[] args) {
        Observable<Integer> vals = Observable.range(1,5);

        vals.map(i -> intenseCalculation(i))
                .map(i -> {
                    System.out.println("Multiplying " + i + " on " + Thread.currentThread().getName());
                    return i * 10;
                })
                .subscribeOn(Schedulers.computation())
                .subscribe(val -> System.out.println("Subscriber received "
                        + val + " on "
                        + Thread.currentThread().getName()));

        sleep(20000);
//        Observable.fromCallable(() -> {
//            System.out.println("Composing input stream on " + Thread.currentThread().getName());
//            return "T0";
//        })
//                .compose(listSingle -> listSingle.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()))
//                .subscribe(s -> System.out.println("Item received " + s + " on " + Thread.currentThread().getName()));
//
//        sleep(2000);
    }

    public static int intenseCalculation(int i) {
        try {
            System.out.println("Calculating " + i + " on " + Thread.currentThread().getName());
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000,3000));
            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
