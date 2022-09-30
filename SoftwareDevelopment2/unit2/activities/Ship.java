package activities;

public class Ship {
    private int hullRating;
    private int shields;
    private int maximumShields;
    private Weapon armament;
    private String name;

    public Ship(int hullRating, int shields, Weapon armament, String name){
        this.hullRating = hullRating;
        this.shields = shields;
        this.maximumShields = shields;
        this.armament = armament;
        this.name = name;
    }

    public Ship(int hullRating, int shields){
        this (hullRating, shields, new Weapon(DamageType.NORMAL, Weapon.NORMAL_DAMAGE_COLOR, 50), "Ship");
    }

    public int getHullRating() {
        return this.hullRating;
    }

    public int getShields() {
        return this.shields;
    }

    public int getMaximumShields() {
        return this.maximumShields;
    }

    public Weapon getArmament() {
        return this.armament;
    }

    @Override
    public String toString(){
        return this.name + ": shields " + this.shields + ", hull " + this.hullRating;
    }
}