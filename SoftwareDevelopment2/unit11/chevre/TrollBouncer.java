package chevre;

public class TrollBouncer implements Runnable {
    private ClubChevre club;

    public TrollBouncer(ClubChevre club){
        this.club = club;
    }

    @Override
    public void run() {
        while(this.club.numberOfGoatsInLine() > 0){
            if(this.club.isAtCapacity()){
                synchronized(this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // squash
                    }
                }
            }
            Goat goat = this.club.getGoatAtPosition(0);
            synchronized(goat){
                goat.notify();
                this.club.removeGoatFromLine(goat);
                this.club.startDancing(goat);
            }
        }
    }
}