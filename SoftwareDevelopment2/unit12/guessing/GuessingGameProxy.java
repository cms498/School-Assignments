package guessing;

import java.io.IOException;
import java.net.Socket;

import duplexer.Duplexer;

public class GuessingGameProxy extends Duplexer implements GuessingGame{

    public GuessingGameProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void restart(){
        send("RESTART");
        try{
            String response = recieve();
            if(!response.equals("RESTARTED")){
                throw new IllegalStateException("Bad response from server");
            }
        } catch (IOException e){
            System.out.println("IOException on recieve");
            close();
        }
    }

    @Override
    public GuessResult guess(int number) {
        send("GUESS "+ number);
        try{
            String response = recieve();
            return GuessResult.valueOf(response);
        } catch (IOException e){
            System.out.println("IOException on recieve");
            close();
            return null;
        }
    }

    @Override
    public void quit() {
        send("QUIT");
        try {
            String response = recieve();
            System.out.println(response);
        } catch (IOException e) {
            // squash
        }
        close();
    }
}