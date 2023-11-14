package cmh.application;

import java.util.Objects;

public class Cop {
    private static int amount = 0;
    private final String name;
    private Location location;
    private Weapon rangedWeapon;
    private Weapon meleeWeapon;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void shout(String phrase){
        System.out.println(name + " закричал: " + phrase);
    }

    public void swing(){
        System.out.println(name + " взмахнул " + meleeWeapon);
    }

    public void shoot(Thing target){
        rangedWeapon.dealDamage(target);
    }

    public void melee(Thing target){
        meleeWeapon.dealDamage(target);
    }

    @Override
    public String toString() {
        return "Полицейский " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cop cop = (Cop) o;
        return Objects.equals(name, cop.name) && Objects.equals(rangedWeapon, cop.rangedWeapon) && Objects.equals(meleeWeapon, cop.meleeWeapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rangedWeapon, meleeWeapon);
    }

    public String getName() {
        return name;
    }

    public Weapon getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(Weapon rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }

    public Weapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(Weapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public Cop(String name) {
        this.name = name;
        rangedWeapon = new Weapon("Ружьё");
        meleeWeapon = new Weapon("Дубинка");
    }

    public Cop() {
        this.name = "Полицейский "+ amount;
        rangedWeapon = new Weapon("Ружьё");
        meleeWeapon = new Weapon("Дубинка");
        amount++;
    }
}
