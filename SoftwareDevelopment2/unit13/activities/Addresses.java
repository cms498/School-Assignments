package activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Addresses {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getByName("localhost"));
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getByName("www.google.com").getHostName());
        System.out.println(InetAddress.getByName("www.google.com").getHostAddress());
    }
}