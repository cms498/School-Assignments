package gvt;

public class Attack {
    private String name;
    private DamageType DamageType;
    private int numberOfHits;
    private int DamageAmount;

    public Attack(String name, DamageType DamageType, int numberOfHits, int DamageAmount){
        this.name = name;
        this.DamageType = DamageType;
        this.numberOfHits = numberOfHits;
        this.DamageAmount = DamageAmount;
    }

    public String getName() {
        return name;
    }

    public int getnumberOfHits() {
        return numberOfHits;
    }

    public DamageType getDamageType() {
        return DamageType;
    }

    public int getDamageAmount() {
        return DamageAmount;
    }

    @Override
    public String toString(){
        return this.name + " attacks " + this.numberOfHits + " for " + this.DamageAmount;
    }
}