package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(54321);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Server recieved = " + message);

        String reply = "UDP ECHO "+ message;
        DatagramPacket outgoing = new DatagramPacket(reply.getBytes(), reply.length(), packet.getAddress(), packet.getPort());
        socket.send(outgoing);

        System.out.println("Server sent message");

        socket.close();
    }
}