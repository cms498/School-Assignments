/**
 * This assignment makes a mini server, it uses local host with port 8080
 * it prints messages to the server as well as prints hello world on the
 * local host page
 * 
 * Author: Chris Shepard
 */

package assignment13_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyWebServer{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); //creates the serversocket

        while(true){ // client connects, prints connection message to the server, send a message to the client 
            Socket client = serverSocket.accept();
            Scanner scanner = new Scanner(client.getInputStream());
            for(int i = 0; i < 3; i++){
                System.out.println(scanner.nextLine());
            }

            String message = "HTTP/1.1 200 OK\r\n"
            + "Content-Length: 12\r\n"
            + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
            + "Hello World!\r\n";

            client.getOutputStream().write(message.getBytes());
            client.getOutputStream().flush();
            client.close();
        }
    }
}