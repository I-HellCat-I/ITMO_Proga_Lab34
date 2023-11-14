package cmh.application;

public class Weapon extends Thing implements DamageDealer {
    private static int amount = 0;
    public Weapon() {
        super("Оружие " + amount);
        amount++;
    }

    public Weapon(String n){
        super(n);
        amount++;
    }


    @Override
    public void dealDamage(Thing target) {
        if (this.getCondition() == Condition.INTACT) target.damage();
        else System.out.println(this.getName() + " не может нанести урон");
    }
}
