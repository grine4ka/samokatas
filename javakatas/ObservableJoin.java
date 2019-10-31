package javakatas;

import kotlin.Pair;
import rx.Observable;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by g.bykov on 26/03/2017.
 */
public class ObservableJoin {

    public static void main(String[] args) {
        pairObservable().join(stringObservable(),
                pair -> Observable.timer(1000, TimeUnit.SECONDS),
                s -> Observable.timer(1000, TimeUnit.SECONDS),
                joinOn())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(strings -> System.out.println("Received list of strings " + strings.toString()
                        + " on thread " + Thread.currentThread().getName()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Func2<Pair<String, Integer>, String, Pair<Integer, String>> joinOn() {
        return (pair, s) -> new Pair<>(pair.getSecond(), pair.getFirst() + " " + s);
    }

    private static Observable<Pair<String, Integer>> pairObservable() {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("String3", 3));
        list.add(new Pair<>("String2", 2));
        list.add(new Pair<>("String1", 1));
        list.add(new Pair<>("String0", 0));
        list.add(new Pair<>("String-1", -1));
        list.add(new Pair<>("String-2", -2));
        return Observable.from(list).doOnNext(pair -> System.out.println(pair.toString()));
    }

    private static Observable<String> stringObservable() {
        return Observable.from(listOf("String1", "String2", "String3")).doOnNext(s -> System.out.println(s));
    }

    private static <T> List<T> listOf(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

}
