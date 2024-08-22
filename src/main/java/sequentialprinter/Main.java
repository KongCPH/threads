package sequentialprinter;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        PrintJob a = new PrintJob("A", "Hello from A", 20);
        PrintJob b = new PrintJob("B", "I print, too!", 100);
        PrintJob c = new PrintJob("C", "My turn now", 50);

        printer.print(a);
        printer.print(b);
        printer.print(c);
    }
}
