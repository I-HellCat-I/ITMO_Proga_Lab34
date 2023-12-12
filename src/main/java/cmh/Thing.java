package cmh;

import java.util.Objects;


enum Condition{
    BROKEN("Сломано"),
    INTACT("Целое");

    private String strCond;

    private Condition(String strCond){
        this.strCond = strCond;
    }

    public String toString(){
        return strCond;
    }
}

public abstract class Thing extends Entity implements Breakable {
    private Condition condition;
    private String onBreakPhrase;

    public Thing(String n){
        super(n);
        condition = Condition.INTACT;
    }

    public Thing(String n, String obf){
        super(n);
        condition = Condition.INTACT;
        onBreakPhrase = obf;
    }
    public void use(Location nearRocket) {}

    @Override
    public String toString() {
        return name;
    }

    public Condition getCondition(){
        return condition;
    }

    public void setCondition(Condition c){
        this.condition = c;
    }

    @Override
    public void damage() {
        this.break_();
    }

    @Override
    public void break_(){
        condition = Condition.BROKEN;
        this.onBreakEvent();
    }

    @Override
    public void onBreakEvent() {
        //System.out.println(onBreakPhrase + " " + this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return condition == thing.condition && Objects.equals(name, thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, name);
    }
}

