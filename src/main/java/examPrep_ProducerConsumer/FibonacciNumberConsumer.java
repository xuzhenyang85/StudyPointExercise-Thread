
package examPrep_ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class FibonacciNumberConsumer implements Runnable{
    
    protected BlockingQueue<Integer> numbersProduced;
    protected BlockingQueue<Integer> numbersConsumer;
    
    public FibonacciNumberConsumer(BlockingQueue<Integer> numbersProduced,BlockingQueue<Integer> numbersConsumer) 
    {
        this.numbersProduced = numbersProduced;
        this.numbersConsumer = numbersConsumer;
    }
    
    int sumTotal = 0;
    
    @Override
    public void run() {
        while(true){
            try {
                sumTotal += numbersProduced.take();
                System.out.println("Sum: " + sumTotal);
            } catch (InterruptedException ex) {
                System.out.println("Fejl i Consumer");
            }
            
        }
    }
    
    public int getSumTotal(){
        return sumTotal;
    }
    
    
    
}
