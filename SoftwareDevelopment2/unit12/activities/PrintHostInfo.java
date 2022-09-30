package activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo {
    public static void main(String[] args) throws UnknownHostException{
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("Host Name = " + local.getHostName());
        System.out.println("Host Address = " + local.getHostAddress());
    }
}