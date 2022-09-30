package guessing;

import java.io.IOException;
import java.net.Socket;

public class NetworkGuessingGame {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 12347);
        GuessingGameProxy proxy = new GuessingGameProxy(socket);
        GamePlayer player = new GamePlayer(proxy);
        player.playTheGame();
    }
}