package gvt;

public abstract class Goat {
    private String name;
    private int maxHP;
    private int currentHP;

    public Goat(String name, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public void heal(int hitPoints){
        this.currentHP += hitPoints;
        if(this.currentHP > this.maxHP){
            this.currentHP = this.maxHP;
        }
    }

    public boolean isConscious(int currentHP){
        return this.currentHP > 0;
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
    
    void reduceHP(double amount){
        this.currentHP -= amount;
        if(this.currentHP < 0){
            this.currentHP = 0;
        }
    }

    @Override
    public String toString(){
        return this.name + " {" + this.currentHP + "/" + this.maxHP + "}";
    }
}