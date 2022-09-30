/**
 * This program represents the server side, it takes in client input, performs
 * the necessary calculations and sends the result back to the client,
 * it looks forever until the user kills it
 * 
 * Author: Chris Shepard
 */

package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class CalculatorServer {
    public static void main(String[] args) throws IOException{
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS); // create the calculator

        while(true){
            DatagramSocket socket = new DatagramSocket(12400);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet); // recieve the client input
    
            String recieved = new String(packet.getData(), 0, packet.getLength());

            String[] tokens = recieved.strip().split(" ");

            String result = "" + calculator.calculate(recieved.charAt(0) + "", 
            Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])); //perform the calculation
    
            DatagramPacket outGoing = new DatagramPacket(result.getBytes(), result.length(), packet.getAddress(), packet.getPort());
            socket.send(outGoing); //send the client the result
    
            socket.close();
        }
    }
}