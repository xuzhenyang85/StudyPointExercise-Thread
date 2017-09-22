package examPrep_ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> s1 = new ArrayBlockingQueue(20);
        ArrayBlockingQueue<Integer> s2 = new ArrayBlockingQueue(20);

        ExecutorService es = Executors.newCachedThreadPool();
        //Create and start four producers (P1-P4 in the exercise-figure)
        es.execute(new FibonacciNumberProducer(s1, s2));
        es.execute(new FibonacciNumberProducer(s1, s2));
        es.execute(new FibonacciNumberProducer(s1, s2));
        es.execute(new FibonacciNumberProducer(s1, s2));
        
        s1.add(4);
        s1.add(5);
        s1.add(8);
        s1.add(12);
        s1.add(21);
        s1.add(22);
        s1.add(34);
        s1.add(35);
        s1.add(36);
        s1.add(37);
        s1.add(42);
        
        es.shutdown();
    
        //System.out.println("Sum: " + s2.);
    }

}
