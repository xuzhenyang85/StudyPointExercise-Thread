package examPrep_ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class FibonacciNumberProducer implements Runnable {

    protected BlockingQueue<Integer> numbersProduced;
    protected BlockingQueue<Integer> numbersConsumer;

    public FibonacciNumberProducer(BlockingQueue<Integer> numbersProduced, BlockingQueue<Integer> numbersConsumer) {
        this.numbersProduced = numbersProduced;
        this.numbersConsumer = numbersConsumer;
    }

    private int fib(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        //int value = fib(numbersProduced.poll());
        try {
            for (int i = 0; i < numbersProduced.size(); i++) {
                int value = fib(numbersProduced.poll());
                numbersConsumer.put(value);
            }
        } catch (InterruptedException ex) {
            System.out.println("Fejl i producer");
        }
    }

}
