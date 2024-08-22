package webprinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Purpose of this demo is to show the most basic use of sockets with inspiration
 * from: https://www.baeldung.com/a-guide-to-java-sockets
 * The server only accepts one client and only one message from the client before
 * closing the connection
 * Author: Thomas Hartmann and Jon Bertelsen
 */
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
                new Thread(new ClientHandler(clientSocket)).start();
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
