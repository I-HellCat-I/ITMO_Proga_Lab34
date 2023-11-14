package cmh.application;


public class Main {
    public static void main(String[] args) {
        Cop rigel = new Cop("Ригель");
        Rocket rocket = new Rocket("Ракета");
        Squad cops = new Squad("Полицейские", rigel, new Cop[]{rigel, new Cop(), new Cop()});

        cops.attack(rocket);
        rigel.swing();
        rigel.shout("Не прекращая пальбы из ружей, полицейские побежали вперед.");
        cops.moveTo(rocket.getNearRocket(), "подбежали к");
        cops.chargePhrase("с яростью набросились на установленные вокруг приборы и принялись уничтожать их:");
        cops.attack(new Device("барометр", "разбит"));
        cops.attack(new Device("сейсмограф", "разломан"));
        cops.attack(new Device("дождемер", "изрешечён"));
        cops.moveTo(new Location("Вышка"), "залезли на");
        cops.attack(new Device("анемометр", "разбит"));
    }
}