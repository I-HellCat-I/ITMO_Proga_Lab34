package cmh.application;


public class Main {
    public static void main(String[] args) {
        Cop rigel = new Cop("Ригель");
        Rocket rocket = new Rocket("Ракета");
        Squad cops = new Squad("Полицейские", rigel, new Cop[]{rigel, new Cop(), new Cop()});
        Device[] devices = {
                new Device("барометр", "разбит"),
                new Device("сейсмограф", "разломан"),
                new Device("дождемер", "изрешечён"),
                new Device("анемометр", "разбит")};
        cops.attack(rocket);
        rigel.swing();
        rigel.shout("Не прекращая пальбы из ружей, полицейские побежали вперед.");
        cops.moveTo(rocket.getNearRocket(), "подбежали к");
        cops.chargePhrase("с яростью набросились на установленные вокруг приборы и принялись уничтожать их:");
        cops.attack(devices[0]);
        cops.attack(devices[1]);
        cops.attack(devices[2]);
        cops.moveTo(new Location("Вышка"), "залезли на");
        System.out.println(devices[3] + " " + devices[3].getCondition().toString()); // TODO: Выпилить после сдачи 3 лабы
        cops.attack(devices[3]);
        System.out.println(devices[3] + " " + devices[3].getCondition().toString()); // TODO: Выпилить после сдачи 3 лабы
    }
}