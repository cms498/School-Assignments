/**
 * This program represents the client side, it is responsible for inputting commands
 * it recieves the result from the server and continues until the user inputs nothing
 * 
 * Author: Chris Shepard
 */

package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter math operation (or nothing to exit): ");
        String input = scanner.nextLine();
        DatagramSocket socket = new DatagramSocket();

        while(!input.equals(" ")){
            String[] tokens = input.strip().split(" ");
            String result;
            if (tokens.length < 3) {
                result = "error bad request";
            }
            //create the packet based on the users input
            String message = tokens[1] + " " + tokens[0] + " " + tokens[2] + " ";
            DatagramPacket packet = new DatagramPacket(message.getBytes(),
            message.length(), InetAddress.getByName("localhost"), 12400);
            socket.send(packet); //send it to the server

            byte[] buffer = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

            socket.receive(incoming); // recieve the incoming result

            result = new String(incoming.getData(), 0, incoming.getLength());

            System.out.print(result + " ");

            input = scanner.nextLine();

            if(input.equals("")){
                break;
            }

            input = result + " " + input; // take in the users next input 
        }
        //close everything
        scanner.close();
        socket.close();
    }
}