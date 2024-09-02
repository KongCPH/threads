package threadprinter;

public class Main {

    public static void main(String[] args) {

        Thread a = new PrintJob("A", "Hello from A", 20);
        Thread b = new PrintJob("B", "I print, too!", 100);
        Thread c = new PrintJob("C", "My turn now", 500);


        a.start();
        b.start();
        c.start();




    }
}
