package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

/*
 * This is a chatserver with an observer pattern. When one client is writing a message
 * all the clients will receive it. *
 *
 * Author: Signe Kongsgaard
 */
public class WebServer
{

    private static final int PORT = 9090;
    private static Socket clientSocket;
    private static boolean keepRunning;
    // Vi bruger en trådsikker Vector frem for en ArrayList
    private static Vector<Observer> observers = new Vector<>();
    public static void main(String[] args)
    {

        startConnection(PORT);
    }

    public static void startConnection(int port)
    {
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            keepRunning = true;
            while(keepRunning){
                clientSocket = serverSocket.accept(); // blocking call
                ClientHandler ch = new ClientHandler(clientSocket);
                observers.add(ch);
                new Thread(ch).start();
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

    public static void stopConnection()
    {
            System.out.println("Closing down socket ...");
    }

    public static void notifyAllObservers(String msg){
        for(Observer o: observers){
          o.notifyMe(msg);
        }
    }


    public static boolean removeObserver(Observer o){
        return observers.remove(o);
    }

}
