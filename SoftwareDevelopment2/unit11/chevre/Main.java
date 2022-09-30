package chevre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClubChevre clubChevre = new ClubChevre();
        TrollBouncer bouncer = new TrollBouncer(clubChevre);
        clubChevre.setBouncer(bouncer);
        Thread bouncerThread = new Thread(bouncer);
        ArrayList<Thread> threads = new ArrayList<>(); 
        for(int i = 0; i < 10; i++){
            Goat goat = new Goat(clubChevre);
            Thread thread = new Thread(goat);
            thread.start();
            threads.add(thread);
        }
        bouncerThread.setDaemon(true);
        bouncerThread.start();
        for(Thread thread : threads){
            System.out.println("Waitng for " + thread.getName());
            System.out.println("Club line " + clubChevre.getLine());
            System.out.println("Club floor " + clubChevre.getDanceFloor());
            thread.join();
        }
        System.out.println("The club has closed!");
    }
}