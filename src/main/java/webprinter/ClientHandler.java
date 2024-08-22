package webprinter;

import threadprinter.PrintJob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler (Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Hello client. What is your name?");
            String name = in.readLine();
            out.println("What would you like me to print?");
            String msg = in.readLine();
            out.println("How many prints would you like?");
            int noOfPrints = Integer.parseInt(in.readLine());
            out.println("Server is printing...");
            Printer printer = Printer.getPrinter();
            printer.print(new PrintJob(name, msg, noOfPrints));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
