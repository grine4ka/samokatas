package ru.bykov.javakatas;

import rx.Single;
import rx.schedulers.Schedulers;

import java.util.*;

/**
 * Created by g.bykov on 26/03/2017.
 */
public class ObservableConcatWithSkip {

    private static Set<String> dbStrings = new HashSet<>();

    public static void main(String[] args) {
        dbStrings.add("String4");
        remoteList().concatWith(localList()).skip(1)
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

    private static Single<List<String>> localList() {
        return Single.fromCallable(() -> new ArrayList<>(dbStrings));
    }

    private static Single<List<String>> remoteList() {
        return Single.fromCallable(() -> listOf("String1", "String2", "String3"))
                .doOnSuccess(strings -> {
                    dbStrings.addAll(strings);
                    System.out.println("Strings saved to base");
                });
    }

    private static List<String> listOf(String... strings) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }

}
