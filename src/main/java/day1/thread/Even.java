package day1.thread;

public class Even extends Thread {

    private static int n = 0;

    public static int next() {
        n++;
        n++;
        return n;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> {
                next();
                System.out.println("Thread 1: " + n);
            });

            Thread t2 = new Thread(() -> {
                next();
                System.out.println("Thread 2: " + n);

            });
            t1.start();
            t2.start();
            Thread.sleep(1000);
        }
    }
}
