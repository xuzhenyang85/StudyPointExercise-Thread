
package day1.thread;

public class EvenTest {
    
    public static void main(String[] args) throws InterruptedException {
        Even even = new Even();
        
        EvenThread t1 = new EvenThread(even);
        EvenThread t2 = new EvenThread(even);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Result: " + even.next());
    }
}
