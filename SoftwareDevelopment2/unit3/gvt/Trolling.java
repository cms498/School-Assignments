package gvt;

public class Trolling extends Troll{
    private static String TROLLING_NAME = "Trolling";
    private static int TROLLING_HP = 38;
    private static double TROLLING_REGEN = 0.03;

    public Trolling(){
        super(TROLLING_NAME, TROLLING_HP, TROLLING_REGEN);
    }

    @Override
    public Attack attack() {
        return new Attack("U Mad", DamageType.PHYSICAL, 1, 15);

    }

    @Override
    public void takeDamage(Attack attack) {
        double modified = 1.0;
        if(attack.getDamageType() == DamageType.MAGICAL){
            modified = 1.25;
        }
        for(int hit = 0; hit < attack.getnumberOfHits(); hit++){
            int modifiedAmount = (int)(attack.getDamageAmount() * modified);
            reduceHP(modifiedAmount);
        }
    }
}