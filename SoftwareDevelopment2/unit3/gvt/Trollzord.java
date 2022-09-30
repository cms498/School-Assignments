package gvt;

public class Trollzord extends Troll{
    private static int TROLLZORD_HP = 64;
    private static double TROLLZORD_REGEN = 0.05;
    private static String TROLLZORD_NAME = "Trollzord";
    public Trollzord(){
        super(TROLLZORD_NAME, TROLLZORD_HP, TROLLZORD_REGEN);
    }

    @Override
    public Attack attack(){
        return new Attack("Flame War", DamageType.MAGICAL, 1, 25);
    }

    @Override
    public void takeDamage(Attack attack){
        double modified = 1.0;
        if(attack.getDamageType() == DamageType.HOLY){
            modified = 1.25;
        }
        for(int hit = 0; hit < attack.getnumberOfHits(); hit++){
            int modifiedAmount = (int)(attack.getDamageAmount() * modified);
            reduceHP(modifiedAmount);
        }
    }
}