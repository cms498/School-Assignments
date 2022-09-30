/**
 * This program represents a client using shell commands
 * The user will specify what host they would like to connent to, and then type in
 * shell commands, and the output from the server will be displayed on the screen
 * 
 * Author: Chris Shepard
 */

package bindshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ShellClient {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shell host and IP [default is localhost 48879]");
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        String host = tokens[0];
        if(host.length() < 2){
            host = "localhost";
        }
        String SIP = "";
        if(tokens.length < 2){
            SIP = "48879";
        } else {
            SIP = tokens[1];
            if(SIP.length() < 2){
                SIP = "48879";
            }
        }
        int IP = Integer.parseInt(SIP);
        Socket socket = new Socket(host, IP); //create the socket to open connection to the server

        System.out.println("[+] Client Connection Successful to " + socket.getLocalAddress() + ":" + socket.getPort());

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String banner = reader.readLine();
        System.out.println(banner);

        System.out.println("[+>] Enter a command");

        String command = scanner.nextLine();
        PrintWriter writer = new PrintWriter(socket.getOutputStream()); //after the command is entered, recieve server response

        while(!command.equals("bye")){ //keep giving commands and printing response until bye
            writer.println(command);
            writer.flush();
            Scanner scanner2 = new Scanner(socket.getInputStream());
            while(scanner2.hasNext()){
                String message = scanner2.nextLine();
                if(message.equals("endcom")){
                    break;
                } else {
                    System.out.println(message);
                }
            }
            System.out.println("[+>] Enter a command");
            command = scanner.nextLine();
        }

        scanner.close(); //close everything
        writer.close();
        socket.close();
    }
}