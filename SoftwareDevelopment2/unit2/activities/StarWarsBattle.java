package activities;

public class StarWarsBattle {
    public static void main(String[] args) {
        Weapon w = new Weapon(DamageType.ION, Weapon.ION_DAMAGE_COLOR, 25);
        System.out.println(w.getDamageType());
        System.out.println(w.getColor());
        System.out.println(w.getDamageAmount());

        Ship s = new Ship(100, 50, w, "Cargo");
        System.out.println(s.getHullRating());
        System.out.println(s.getShields());

        Ship tie = new Ship(50, 0);
        System.out.println(tie.getHullRating());
        System.out.println(tie.getShields());

        System.out.println(tie);
        System.out.println(s);

        Weapon w2 = new Weapon(DamageType.HEAVY, Weapon.HEAVY_DAMAGE_COLOR, 20);
        Weapon w3 = new Weapon(DamageType.HEAVY, Weapon.HEAVY_DAMAGE_COLOR, 20);

        System.out.println(w2 == w3);
        System.out.println(w2.equals(w3));
        System.out.println(w.equals(w3));
    }
}