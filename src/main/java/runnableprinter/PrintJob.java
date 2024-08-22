package runnableprinter;


public class PrintJob implements Runnable{

    private String msg;
    private String jobName;
    private int noOfPrints;

    public PrintJob(String name, String msg, int noOfPrints){
        this.jobName = name;
        this.msg = msg;
        this.noOfPrints = noOfPrints;
    }

    public String getMsg(){
        return msg;
    }

    public String getJobName(){
        return jobName;
    }

    public int getNoOfPrints(){
        return noOfPrints;
    }

    public void run(){
        Printer printer = Printer.getPrinter();
        printer.print(this);
    }



}
