package day1.fib;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread {

    private long tal = 0;
    FibonacciObserver observer;

    public void registerFibonacciObserver(FibonacciObserver o) {
        observer = o;
    }

    public FibonacciTask(long n) {
        this.tal = n;
    }
    
    private synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        //Call the Fibonacci method from here
    
    long result = fib(this.tal);
    
    observer.dataReady(result);
}
}
