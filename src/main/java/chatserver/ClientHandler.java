package chatserver;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler implements Runnable, Observer{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler (Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){

        try {
            String input = "";
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Hello client. What is your name?");
            clientName = in.readLine();
            out.println("Welcome. You can chat now. End the program by typing stop");
            WebServer.notifyAllObservers(clientName + " has entered the chat");
            boolean keeprunning = true;
            while (keeprunning){
                String msg = in.readLine();
                if(msg.equals("stop")){
                    keeprunning = false;
                    WebServer.removeObserver(this);
                    out.println("Goodbye " + clientName);
                    WebServer.notifyAllObservers(clientName + " has left the chat");
                }
                else{
                    WebServer.notifyAllObservers(clientName + " says: " + msg);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void notifyMe(String msg){
        out.println(msg);
    }
}
