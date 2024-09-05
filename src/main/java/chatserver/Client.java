package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


        private static final int PORT = 9090;
        private static final String IP = "127.0.0.1";

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String response = "";
        private Scanner scanner = new Scanner(System.in);
        private MessageReceiver receiver;



        public void connectToServer()
        {

            startConnection(IP, PORT);
            // vi laver en ny tråd til at modtage beskeder fra server
            // så vi kan skrive og modtage beskeder asynkront
            receiver = new MessageReceiver(in);
            Thread t1 = new Thread(receiver);
            t1.start();
            chat();
            receiver.stop();
            stopConnection();
        }

        public void startConnection(String ip, int port)
        {
            try
            {
                System.out.println("Starting client socket talking to server on IP: " +
                        IP + " and port number: " + PORT);
                clientSocket = new Socket(ip, port);
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            catch (IOException e)
            {
                System.out.println("Error reading from server");
            }
        }

        public void chat(){
            boolean keeprunning = true;
            Scanner scanner = new Scanner(System.in);
            while(keeprunning){
                String msg = scanner.nextLine();
                if(msg.equals("stop"))
                    keeprunning = false;
                out.println(msg);
            }
        }
        public void stopConnection()
        {
            try
            {
                System.out.println("Closing down client socket");
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Client closed");
            }
            catch (IOException e)
            {
                System.out.println("We could not close client connection");
            }
        }

    }


