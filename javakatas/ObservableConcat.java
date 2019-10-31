package javakatas;

import kotlin.Pair;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class ObservableConcat {

    public static void main(String[] args) {
        Observable.concat(
                localPair(),
                remotePair().subscribeOn(Schedulers.newThread())
        )
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(pair -> System.out.println("Received pair number " + pair.getFirst() + " with name " + pair.getSecond()
                + " on thread " + Thread.currentThread().getName()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Observable<Pair<Integer, String>> remotePair() {
        return Observable.defer(() -> {
            System.out.println("remote pair on thread " + Thread.currentThread().getName());
            return Observable.zip(
                    Observable.just(2),
                    Observable.just("remote"),
                    Pair::new
            );
        });
    }

    private static Observable<Pair<Integer, String>> localPair() {
        return Observable.defer(() -> {
            System.out.println("local pair on thread " + Thread.currentThread().getName());
            return Observable.zip(
                    Observable.just(1),
                    Observable.just("local"),
                    Pair::new
            );
        });
    }
}
