package gvt;

import java.util.Random;

public class Thief extends Goat{
    private static Random RNG = new Random();
    public Thief(String name){
        super(name, 75);
    }

    @Override
    public Attack attack(){
        int hits = RNG.nextInt(3) + 1;
        return new Attack("Stabbity-stab", DamageType.POISON, hits, 15);
    }

    @Override
    public void takeDamage(Attack attack){
        for(int hit = 0; hit < attack.getnumberOfHits(); hit ++){
            double dodgeChange = RNG.nextDouble();
            if(dodgeChange >= 0.3){
                reduceHP(attack.getDamageAmount());
            }
        }
    }
}