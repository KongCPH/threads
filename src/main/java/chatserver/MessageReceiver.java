package chatserver;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageReceiver implements Runnable{

    private BufferedReader in;
    private boolean keeprunning = true;

    public MessageReceiver(BufferedReader in){
        this.in = in;
    }

    public void run(){

        while(keeprunning){
            String msg = null;
            try {
                msg = in.readLine();
            } catch (IOException e) {
                System.out.println("We cannot receive from the server. Program is shutting down");
                keeprunning = false;
            }
            System.out.println(msg);
        }
    }

    public void stop(){
        keeprunning = false;
    }
}
