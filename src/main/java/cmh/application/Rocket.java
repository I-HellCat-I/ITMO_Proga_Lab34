package cmh.application;

public class Rocket extends Thing{
    private static int amount = 1;
    private final Location nearRocket;
    private final Location insideRocket;
    public Rocket(){
        super("Ракета "+amount);
        nearRocket = new Location(this.getName());
        insideRocket = new Location(this.getName());
        amount++;
    }

    public Location getNearRocket(){
        return nearRocket;
    }

    public Rocket(String n){
        super(n);
        nearRocket = new Location("Около " +this.getName());
        insideRocket = new Location("Внутри " + this.getName());
        amount++;
    }

    @Override
    public void damage() {

    }

    @Override
    public void onBreakEvent() {
        System.out.println("Сломана Ракета " + this.getName());
    }

    public Location getInsideRocket() {
        return insideRocket;
    }
}
