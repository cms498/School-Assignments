package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NewworkTime {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("time.nist.gov", 13);
        InputStream input = sock.getInputStream();

        Scanner sc = new Scanner(input);
        while(sc.hasNext()){
            String message = sc.nextLine();
            System.out.println(message);
        }

        sock.close();
        input.close();
        sc.close();
    }
}