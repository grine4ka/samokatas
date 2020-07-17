package javakatas;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class FlatMapSubjectsTest {

    public static void main(String[] args) {
        BehaviorSubject<String> originSource = BehaviorSubject.create("Default origin");
        BehaviorSubject<String> flatMapSource = BehaviorSubject.create("flatMap 0");

        Observable<String> underTest = flatMapSource.asObservable();
        originSource.flatMap(ignored -> underTest)
                .subscribe(result -> System.out.println("Received string " + result));

        originSource.onNext("string");
        flatMapSource.onNext("flatMap 1");
        originSource.onNext("string");
        flatMapSource.onNext("flatMap 2");
        originSource.onNext("string");
        flatMapSource.onNext("flatMap 3");
    }
}
