package sequentialprinter;

public class Printer {

    public void print(PrintJob job){
        for(int i = 0; i < job.getNoOfPrints(); i++){
            System.out.println(job.getName() + ": " + job.getMsg());
        }
    }
}
