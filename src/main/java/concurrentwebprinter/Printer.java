package concurrentwebprinter;


import java.util.Random;

public class Printer {
    private static Printer printer = new Printer();

    public void print(PrintJob job){
        Random random = new Random();
        for(int i = 0; i < job.getNoOfPrints(); i++){
            System.out.println(job.getName() + ": " + job.getMsg());
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("Someone woke the thread up");
            }
        }
    }

    private Printer(){

    }

    public static Printer getPrinter(){
        return printer;
    }
}
