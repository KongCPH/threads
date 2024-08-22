package synchronizedprinter;


public class Printer {
    private static Printer printer = new Printer();

    public void print(PrintJob job){
        for(int i = 0; i < job.getNoOfPrints(); i++){
            System.out.println(job.getJobName() + ": " + job.getMsg());
        }
    }

    private Printer(){

    }

    public static Printer getPrinter(){
        return printer;
    }

    public synchronized void printBatch(PrintJob job) {
        for(int i = 0; i < job.getNoOfPrints(); i++){
            System.out.println(job.getJobName() + i + ": " + job.getMsg());
        }
    }

    public void setCounter(){

    }
}
