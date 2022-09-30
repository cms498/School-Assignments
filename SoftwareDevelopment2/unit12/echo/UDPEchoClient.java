package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException{
        String message = "Hello UDP Message";
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 54321);
        socket.send(packet);
        System.out.println("Envelope Sent");

        byte[] buffer = new byte[1024];

        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

        socket.receive(incoming);

        String reply = new String(incoming.getData(), 0, incoming.getLength());

        System.out.println("Client Recieved = " + reply);

        socket.close();
    }
}