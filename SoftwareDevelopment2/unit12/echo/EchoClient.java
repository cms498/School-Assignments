package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 54321);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Hello Message");
        printWriter.flush();

        InputStream in = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String recieved = bufferedReader.readLine();
        System.out.println(recieved);
        
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}