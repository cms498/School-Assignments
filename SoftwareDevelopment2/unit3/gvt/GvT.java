package gvt;

public class GvT {

    public static void main(String[] args) {
        Goat[] party = {
            new Fighter("Meatshield"),
            new Thief("Stealy"),
            new Mage("Hairy Potter")
        };

        Troll[] horde = {
            new Trollzord(),
            new Trolling(),
            new Trollzord()
        };

        battle(party, horde);
    }

    public static void battle(Goat[] party, Troll[] horde){
        boolean goatsAlive = true;
        boolean trollsAlive = true;
        while(true){
            Goat goat = getGoat(party);
            Troll troll = getTroll(horde);

            goatsAlive = goat != null;
            trollsAlive = troll != null;

            if(goatsAlive && trollsAlive){
                Attack goatAttack = goat.attack();
                troll.takeDamage(goatAttack);
                System.out.println(goat.getName() + " attacks " + troll.getName()
                    + " with " + goatAttack);

                Attack trollAttack = troll.attack();
                goat.takeDamage(trollAttack);
                System.out.println(troll.getName() + " attacks " + goat.getName()
                    + " with " + trollAttack);

                System.out.println(goat);
                System.out.println(troll);
            }
        }
            // if(goatsAlive == true){
            //     System.out.println("The goats win");
            // } else if (trollsAlive == true){
            //     System.out.println("The trolls win");
            // } else {
            //     System.out.println("Its a tie");
            // }
    }

    private static Goat getGoat(Goat[] party){
        for(int i = 0; i < party.length; i++){
            if(party[i].isConscious(party[i].getCurrentHP())){
                return party[i];
            }
        }
        return null;
    }

    private static Troll getTroll(Troll[] horde){
        for(int i = 0; i < horde.length; i++){
            if(!horde[i].isVanquished(horde[i].getCurrentHP())){
                return horde[i];
            }
        }
        return null;
    }
}
