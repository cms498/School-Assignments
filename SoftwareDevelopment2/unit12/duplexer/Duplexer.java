package duplexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public Duplexer(Socket socket) throws IOException{
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    public void send(String message){
        System.out.println(">> " + message);
        writer.println(message);
        writer.flush();
    }

    public String recieve() throws IOException{
        String message = reader.readLine();
        System.out.println(">> " + message);
        return message;
    }

    public void close(){
        try{
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e){
            //squash
        }
    }
}