package day2.rndnumberprodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomNumberConsumer implements Runnable {

    protected ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    int sumTotal = 0;
    List<Integer> below50 = new ArrayList();
    List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run() {
        //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume
        for (int i = 0; i < 400; i++) {
            try {
                int value = numbersProduced.take();
                if(value <= 50){
                    below50.add(value);
                }
                else{
                    aboveOr50.add(value);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomNumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < below50.size(); i++) {
            sumTotal += below50.get(i);
            for (int j = 0; j < aboveOr50.size(); j++) {
                sumTotal += aboveOr50.get(i);
            }
        }
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}
