package day1.thread;

import java.util.concurrent.locks.ReentrantLock;

public class exercise1_create_start_end_threads extends Thread {

    private static boolean stm = true;

    public static void main(String[] args) throws InterruptedException {
    ReentrantLock lock = new ReentrantLock();
    
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 1; i < 100; i++) {
                    System.out.println("Thread 1: " + i);
                }
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 1; i <= 5; i++) {
                    try {
                        System.out.println("Thread 2: " + i);
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                int i = 10;
                long start = System.currentTimeMillis();
                long end = start + 10 * 1000;
                while (stm != false) {
                    
                    System.out.println("Thread 3: " + i);
                    i++;
                    if (System.currentTimeMillis() > end) {
                        stm = false;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

    }

}
