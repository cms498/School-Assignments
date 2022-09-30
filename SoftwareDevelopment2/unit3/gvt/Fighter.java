package gvt;

public class Fighter extends Goat{
    public Fighter(String name){
        super(name, 150);
    }

    @Override
    public Attack attack(){
        return new Attack("Cleave", DamageType.PHYSICAL, 1, 25);
    }

    @Override
    public void takeDamage(Attack attack){
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.MAGICAL){
            modifier = 1.25;
        } else if (attack.getDamageType() == DamageType.PHYSICAL){
            modifier = 0.75;
        }
        for(int hit = 0; hit < attack.getnumberOfHits(); hit ++){
            int DamageAmount = attack.getDamageAmount();
            int modified = (int)(DamageAmount * modifier);
            reduceHP(modified);
        }
    }
}