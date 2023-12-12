package cmh;

import java.util.HashSet;
import java.util.Objects;

public class Location {
    private final String name;
    private HashSet<Entity> entities = new HashSet<>();

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name);
    }

    public void addEntity(Entity h) throws AlreadyInTargetLocationException {
        if (entities.contains(h)) {
            throw new AlreadyInTargetLocationException(h, this);
        }
        entities.add(h);
    }

    public HashSet<Entity> getEntities(){
        return entities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void AntiGrav() {
        entities.forEach((a) -> a.setOnTheGround(false));
    }
}
