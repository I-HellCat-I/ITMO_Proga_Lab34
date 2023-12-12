package cmh;

import java.lang.annotation.Inherited;
import java.util.Objects;


@Significance(TypeOfSignificance.NON_SIGNIFICANT)
public abstract class Entity {
    protected final String name;
    private final Integer ID;
    private Location location;
    private boolean onTheGround = true;

    private static class IDGiver{
        private static int amount = 0;
        private static int giveID(){
            amount++;
            return amount-1;
        }
    }

    Entity(String n){
        name = n;
        ID = IDGiver.giveID();
    }

    public int getID(){
        return ID;
    }

    public void setLocation(Location location) {
        this.location = location;
        try {
            location.addEntity(this);
        } catch (AlreadyInTargetLocationException ignored) {/* ну и ладно */}
    }

    public Location getLocation(){
        return location;
    }

    public void moveTo(Location dest, String phrase){
        this.setLocation(dest);
        System.out.println(name + " " + phrase + " " + dest);
    }

    public void moveToEntity(Entity dest, String phrase){
        this.setLocation(dest.getLocation());
        System.out.println(name + " " + phrase + " " + dest);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity h = (Entity) o;
        return Objects.equals(name, h.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }

    public boolean isOnTheGround() {
        return onTheGround;
    }

    public void setOnTheGround(boolean onTheGround) {
        this.onTheGround = onTheGround;
    }
}
