package cmh.application;

import java.util.Objects;

public abstract class Entity {
    protected final String name;
    private final Integer ID;
    private Location location;
    private static int ammount = 0;
    private boolean onTheGround = true;

    public void setLocation(Location location) {
        this.location = location;
        try {
            location.addEntity(this);
        } catch (checked ignored) {/* ну и ладно */}
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

    Entity(String n){
        name = n;
        ID = ammount;
        ammount++;
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
