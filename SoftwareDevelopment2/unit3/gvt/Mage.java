package gvt;

public class Mage extends Goat{
    public Mage(String name){
        super(name, 100);
    }

    @Override
    public Attack attack(){
        return new Attack("Magic Missiles", DamageType.MAGICAL, 4, 9);
    }

    @Override
    public void takeDamage(Attack attack){
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.MAGICAL){
            modifier = 0.75;
        } else if (attack.getDamageType() == DamageType.PHYSICAL){
            modifier = 1.25;
        }
        for(int hit = 0; hit < attack.getnumberOfHits(); hit ++){
            int DamageAmount = attack.getDamageAmount();
            int modified = (int)(DamageAmount * modifier);
            reduceHP(modified);
        }
    }
}