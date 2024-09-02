package runnableprinter;

public class Main {

    public static void main(String[] args) {

        Runnable a = new PrintJob("A", "Hello from A", 20);
        Runnable b = new PrintJob("B", "I print, too!", 100);
        Runnable c = new PrintJob("C", "My turn now", 50);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();
    }
}
