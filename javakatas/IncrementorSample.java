package javakatas;

class Incrementor {
    int count = 0;

    public synchronized void inc() {
        if (count < 10) {
            count++;
            System.out.println(count);
            inc();
        }
    }
}

class IncrementorSample {
    public static void main(String[] args) {
        new Incrementor().inc();
    }
}
