package cmh.application;

import java.util.Objects;
import java.util.SortedMap;


enum Condition{
    BROKEN,
    INTACT
}

public abstract class Thing implements Breakable {
    private Condition condition;
    private String name;
    private String onBreakPhrase;

    public Thing(String n){
        name = n;
        condition = Condition.INTACT;
    }

    public Thing(String n, String obf){
        name = n;
        condition = Condition.INTACT;
        onBreakPhrase = obf;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Condition getCondition(){
        return condition;
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

