package activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("129.21.207.103", 42975);
        PrintWriter printWriter = new PrintWriter(sock.getOutputStream());
        printWriter.println("Chris Shepard");
        printWriter.flush();
        sock.close();
        printWriter.close();
    }
}