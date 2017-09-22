package day1.thread;

public class Even{

    private static int n = 0;
    
    public synchronized int next() {
        n++;
        n++;
        return n;
    }
}
