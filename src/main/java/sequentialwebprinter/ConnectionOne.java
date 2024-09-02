package sequentialwebprinter;

import concurrentwebprinter.Client;

public class ConnectionOne {

    public static void main(String[] args) {
        concurrentwebprinter.Client client = new Client();
        client.connectToServer();
    }
}
