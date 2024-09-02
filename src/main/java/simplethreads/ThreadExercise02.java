package simplethreads;


public class ThreadExercise02 {

    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        Thread t = new Thread(worker);
        t.start();
     //   t.join();
        Thread.sleep(4000);
        t.interrupt();
        System.out.println("DONE");
    }
}
