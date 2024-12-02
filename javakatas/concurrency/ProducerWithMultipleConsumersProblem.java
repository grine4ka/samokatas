package javakatas.concurrency;

class SharedResourceWithNotifyAll {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait();
        }
        data = value;
        available = true;
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();
        }
        available = false;
        notifyAll();
        return data;
    }
}

public class ProducerWithMultipleConsumersProblem {
    public static void main(String[] args) {
        SharedResourceWithNotifyAll resource = new SharedResourceWithNotifyAll();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Produced: " + i);
                    resource.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    int value = resource.consume();
                    System.out.println("Consumer 1 consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    int value = resource.consume();
                    System.out.println("Consumer 2 consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
