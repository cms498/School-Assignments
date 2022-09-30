package gvt;

public abstract class Troll {
    private final String name;
    private final int maxHP;
    private int currentHP;
    private final double regenPercent;

    public Troll(String name, int maxHP, double regenPercent){
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.regenPercent = regenPercent;
    }

    public boolean isVanquished(int currentHP){
        return this.currentHP <= 0;
    }

    public void regenerate(){
        int add = (int)(maxHP * regenPercent);
        this.currentHP += add;
        if(this.currentHP > this.maxHP){
            this.currentHP = this.maxHP;
        }
    }

    void reduceHP(int amount){
        this.currentHP -= amount;
        if(this.currentHP < 0){
            this.currentHP = 0;
        }
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    public String getName() {
        return this.name;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public double getRegenPercent() {
        return this.regenPercent;
    }
}