package guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import duplexer.Duplexer;

public class GuessingGameServer extends Duplexer implements Runnable{
    private final GuessingGame game;

    public GuessingGameServer(Socket client) throws IOException {
        super(client);
        game = new GuessingGameImpl();
    }

    @Override
    public void run(){
        boolean sentinal = true;
        while(sentinal){
            try{
                String request = this.recieve();
                System.out.println(">> " + request);
                String[] tokens = request.split(" ");
                switch(tokens[0]){
                    case "RESTART":
                        game.restart();
                        send("RESTARTED");
                        break;
                    case "QUIT":
                        game.quit();
                        send("GAME_OVER");
                        sentinal = false;
                        break;
                    case "GUESS":
                        int guess = Integer.parseInt(tokens[1]);
                        GuessResult result = game.guess(guess);
                        send(result.toString());
                        break;
                    default:
                        send("ERROR");
                }
            } catch (IOException e){
                System.out.println("IOException on read!");
                sentinal = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(12347);
        while(true){
            Socket client = serverSocket.accept();
            GuessingGameServer gameServer = new GuessingGameServer(client);
            Thread thread = new Thread(gameServer);
            thread.start();
        }
    }
}