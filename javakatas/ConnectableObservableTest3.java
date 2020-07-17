package javakatas;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.PublishSubject;

public class ConnectableObservableTest3 {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        Observable<String> refCount = subject.publish().refCount()
                .doOnCompleted(() -> System.out.println("onCompleted"))
                .doOnNext(s -> System.out.println("onNext"))
                .doOnSubscribe(() -> System.out.println("onSubscribe"))
                .doOnUnsubscribe(() -> System.out.println("onUnsubscribe"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate"));
        Subscriber<String> subscriber = new Subscriber<>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String result) {
                System.out.println("Subscriber 1 Received string " + result);
            }
        };
        Subscriber<String> subscriber1 = new Subscriber<>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String result) {
                System.out.println("Subscriber 1 Received string " + result);
            }
        };
        Subscription subscribe = refCount.subscribe(subscriber);
        Subscription subscribe1 = refCount.subscribe(subscriber1);

        subject.onNext("String 1");
        try {
            Thread.sleep(5000);
            subscribe.unsubscribe();
            subscribe1.unsubscribe();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Subscription subscribe2 = refCount.subscribe(result -> System.out.println("Subscriber 3 Received string " + result));
        subject.onNext("String 2");

        try {
            Thread.sleep(1000);
            subscribe2.unsubscribe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
