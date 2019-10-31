package javakatas;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by g.bykov on 17/01/2017.
 */
public class ObservableCombineLatest {

    public static void main(String[] args) {
        Observable.combineLatest(
                getConcat().subscribeOn(Schedulers.io()),
                Observable.fromCallable(() -> someList()).subscribeOn(Schedulers.io()),
                (list, source) -> combine(list, source))

                .observeOn(Schedulers.newThread())
                .subscribe(source -> System.out.println(source + " on thread " + Thread.currentThread().getName()));

        sleepFor(5000);
    }

    private static String combine(String source, List<String> list) {
        System.out.println("Combining smth very complex with " + source + " on thread " + Thread.currentThread().getName());
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(source);
        for (String s : list) {
            joiner.add(s);
        }
        return joiner.toString();
    }

    private static List<String> someList() {
        return Arrays.asList("source", "is", "dangerous");
    }

    private static void sleepFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Observable<String> getConcat() {
        return Observable.concat(
                local(),
                Observable.error(new UnsupportedOperationException()));
    }

    private static Observable<String> remote() {
        return Observable.fromCallable(() -> {
            System.out.println("Doing something long on remote");
            sleepFor(2000);
            return "remote";
        });
    }

    private static Observable<String> local() {
        return Observable.fromCallable(() -> {
            System.out.println("Doing something long in db");
            sleepFor(2000);
            return "local";
        });
    }
}
