package day1.thread;

public class EvenThread extends Thread{

    Even even;
    
    final int COUNT_MAX = 100000;
    
    EvenThread(Even e) {
        even = e;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_MAX; i++) {
            if((even.next() %2) != 0 ){
                System.out.println("Ups");
            }
        }
    }

}
