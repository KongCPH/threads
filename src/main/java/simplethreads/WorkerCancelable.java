package simplethreads;

class WorkerCancelable implements Runnable{
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();
        int count = 1;
        while(keepRunning){
            System.out.println("Hello");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("I was interrupted!");
                return;
            }
            count++;
            if(count > 3){
                cancel();
            }
        }
    }
    public void cancel() {
        keepRunning = false;
    }
}

