package sequentialwebprinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer
{

    private static final int PORT = 9090;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean keepRunning;
    public static void main(String[] args)
    {
        WebServer server = new WebServer();
        server.startConnection(PORT);
    }

    public void startConnection(int port)
    {
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            keepRunning = true;
            while(keepRunning){
                clientSocket = serverSocket.accept(); // blocking call
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


            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            stopConnection();
        }
    }

    public void stopConnection()
    {
        try
        {
            System.out.println("Closing down socket ...");
            in.close();
            out.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

