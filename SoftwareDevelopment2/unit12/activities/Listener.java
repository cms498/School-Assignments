package activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(12347);
        System.out.println("Waiting");
        Socket client = s.accept();
        System.out.println("Accepted!");
        client.close();
        s.close();
    }
}