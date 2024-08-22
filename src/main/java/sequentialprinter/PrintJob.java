package sequentialprinter;

public class PrintJob {

    private String msg;
    private String name;
    private int noOfPrints;

    public PrintJob(String name, String msg, int noOfPrints){
        this.name = name;
        this.msg = msg;
        this.noOfPrints = noOfPrints;
    }

    public String getMsg(){
        return msg;
    }

    public String getName(){
        return name;
    }

    public int getNoOfPrints(){
        return noOfPrints;
    }



}
