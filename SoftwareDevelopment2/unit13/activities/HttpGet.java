package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpGet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.npr.org", 80);

        OutputStream outputStream = socket.getOutputStream();

        String message = "GET / HTTP/1.1\r\n" + "Host: www.npr.org\r\n" + "Connection: close\r\n\r\n";

        outputStream.write(message.getBytes());

        InputStream inputStream = socket.getInputStream();

        Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        socket.close();
    }
}