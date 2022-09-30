package gvt;

public class GoatFight {
    public static void fight(Goat g1, Goat g2){
        while(g1.isConscious(g1.getCurrentHP()) && g2.isConscious(g2.getCurrentHP())){
            Attack attack1 = g1.attack();
            System.out.println(attack1);
            g2.takeDamage(attack1);
            Attack attack2 = g2.attack();
            System.out.println(attack2);
            g1.takeDamage(attack2);

            System.out.println(g1);
            System.out.println(g2);
        }

        if(g1.isConscious(g1.getCurrentHP()) && !g2.isConscious(g2.getCurrentHP())){
            System.out.println(g1.getName() + " wins!");
        } else if (!g1.isConscious(g1.getCurrentHP()) && g2.isConscious(g2.getCurrentHP())){
            System.out.println(g2.getName() + " wins!");
        } else{
            System.out.println("Its a tie!");
        }
    }

    public static void main(String[] args) {
        Goat mage = new Mage("Hairy Potter");
        //Goat fighter = new Fighter("Goat Man");
        Goat thief = new Thief("Bilbo Goatgins");
        fight(mage, thief);
        //fight(mage, fighter);
    }
}