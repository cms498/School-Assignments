package activities;

public class Weapon{
    public static final String ION_DAMAGE_COLOR = "Blue";
    public static final String NORMAL_DAMAGE_COLOR = "Red";
    public static final String HEAVY_DAMAGE_COLOR = "Green";

    private DamageType damageType;
    private String color;
    private int damageAmount;

    public Weapon(DamageType damageType, String color, int damageAmount){
        this.damageType = damageType;
        this.color = color;
        this.damageAmount = damageAmount;
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public String getColor() {
        return this.color;
    }

    public int getDamageAmount() {
        return this.damageAmount;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Weapon)){
            return false;
        }
        Weapon other = (Weapon)(o);
        return (this.damageAmount == other.damageAmount && this.damageType.equals(other.damageType));
    }
}