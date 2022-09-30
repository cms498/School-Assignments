package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("Waiting for client...");
        Socket client = serverSocket.accept();
        System.out.println("Client connected");

        PrintWriter writer = new PrintWriter(client.getOutputStream());

        InputStream in = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);
        writer.println(line + " this you?");
        writer.flush();

        bufferedReader.close();
        writer.close();
        client.close();
        serverSocket.close();
    }
}