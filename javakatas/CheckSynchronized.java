package javakatas;

import java.util.concurrent.ThreadLocalRandom;

public class CheckSynchronized {

    private static class A {

        private volatile int i;

        synchronized void set1() {
            i += 1;
            System.out.println("set " + i + " " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(0, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.set1();
            }).start();
        }
    }
}
