package cmh.application;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Queue;


record R(Cop c, Queue<Thing> toAttack) {
    public R{
        if (toAttack.size() == 0){
            throw new EmptyStackException();
        }
    }
    public void attack(){
        c.getRangedWeapon().dealDamage(toAttack.poll());
    }
}
public class Cop extends Human {
    private static int amount = 0;
    private Weapon rangedWeapon;
    private Weapon meleeWeapon;

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
        super(name);
        rangedWeapon = new Weapon("Ружьё");
        meleeWeapon = new Weapon("Дубинка");
    }

    public Cop() {
        super("Полицейский "+ amount);
        rangedWeapon = new Weapon("Ружьё");
        meleeWeapon = new Weapon("Дубинка");
        amount++;
    }
}
