package chevre;

public class Goat implements Runnable{
    private String name;
    private int coolness;
    private int stamina;
    private ClubChevre club;

    public Goat(ClubChevre club){
        this.name = Utils.makeGoatName();
        this.coolness = Utils.getRandomNumber(1, 100);
        this.stamina = Utils.getRandomNumber(5, 10);
        this.club = club;
    }

    @Override
    public void run() {
        synchronized(this.club.getLine()){
            System.out.println(this.name + " is behind " + this.club.numberOfGoatsInLine() + " goats in line");
            this.club.getInLine(this);
        }
        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                //squash
            }
        }
        System.out.println(this.name + " enters the club");

        while(this.getStamina() > 0){
            System.out.println(this.name + " has " + this.stamina + " stamina left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }
            this.stamina -= 1;
        }
        synchronized(this.club.getDanceFloor()){
            this.club.stopDancing(this);
            System.out.println(this.name + " has stopped dancing");
            this.club.getDanceFloor().notify();
            this.club.leaveClub();
        }
    }

    public int getCoolness() {
        return coolness;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public ClubChevre getClub() {
        return club;
    }

    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        Goat goat = new Goat(club);
        Thread thread = new Thread(goat);
        thread.start();
    }
}