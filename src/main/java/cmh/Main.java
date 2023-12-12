package cmh;


import java.util.Optional;
public class Main { /* TODO: загуглить minorCollection majorCollection, сделать кастомную нотацию задающую поле

 Из текста "Незнайка на луне" то же самое, но +5 предложений до предложения "Убедившись что пули не...", + 5 предложеий после чтоб разбить анемометр. */
    public static String shouldBePurged(Object obj){
        //System.out.println(obj);
        Optional<Significance> op = Optional.ofNullable(obj.getClass().getAnnotation(Significance.class));
        if (op.isEmpty()){
            return "Не от чего избавляться";
        }
        switch (op.get().value()){
            case SEMI_SIGNIFICANT -> {
                return "Следует обдумать надо ли избавляться от этого";
            }
            case SIGNIFICANT -> {
                return "Не стоит избавляться от этого";
            }
            case NON_SIGNIFICANT -> {
                return "Можно избавляться";
            } default -> {
                return "???";
            }
        }
    }
    public static void main(String[] args) {
        Rocket rocket = new Rocket("Ракета");
        Location insideRocket = rocket.getInsideRocket();
        Medic pilulkin = new Medic("Доктор Пилюлькин");
        pilulkin.setLocation(insideRocket);
        Human klepka = new Human("Клепка");
        klepka.setLocation(insideRocket);
        Human znaika = new Human("Знайка");
        znaika.setLocation(insideRocket);
        //@Significance(value = TypeOfSignificance.NON_SIGNIFICANT)
        Cop rigel = new Cop("Ригель");

        znaika.setHeldDevice(new Device("Прибор невесомости"){
            public void use(Location l) {
                l.AntiGrav();
                System.out.println(this + " включен.");
            }
        });
        znaika.setOnNoticeShootingListener(new Listener() {
            @Override
            public void notify(Human human) {
                System.out.println("Услышав, что пули так и барабанят по стальной оболочке ракеты, "+human+" посмотрел в иллюминатор.");
            }
        });
        klepka.addWound("пуля прошла навылет", ", не задев кость");
        pilulkin.fastHealthCheck(klepka);
        pilulkin.moveToEntity(klepka, "бросился со своей походной аптечкой к");
        pilulkin.heal(klepka, " быстро остановил кровотечение и наложил на рану повязку.");
        klepka.endure();

        znaika.noticeShooting();
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
        znaika.customSpeech("Это что же за варварство такое! – вскипел от негодования Знайка.");
        znaika.say("Ну, подождите-ка, я покажу вам!");
        znaika.getHeldDevice().use(rocket.getNearRocket());
        try{
            cops.inTheAirReaction();
        } catch (SquadNotInTheAirException e){
        e.getSuppressed();
            System.out.println("Полицейские не в воздухе");
        }
        cops.attack(rocket);
        cops.attack(rocket);
        cops.attack(rocket);
        cops.attack(rocket);
        System.out.println(shouldBePurged(rigel)); // 451 f
        System.out.println(shouldBePurged(klepka));

        //System.out.println(pilulkin.getID());
        //System.out.println(znaika.getID());


        /*System.out.println(devices[3] + " " + devices[3].getCondition().toString()); // TODO: Выпилить после сдачи 3 лабы
        cops.attack(devices[3]);
        System.out.println(devices[3] + " " + devices[3].getCondition().toString()); // TODO: Выпилить после сдачи 3 лабы
        cops.callOver();
        Optional<Cop> op = Optional.of(rigel);
        devices[0].setCondition(Condition.INTACT);
        System.out.println(devices[0] + " " + devices[0].getCondition().toString());
        AbstractQueue<Thing> queue = new AbstractQueue<Thing>() {
            private int ind = 0;
            private ArrayList<Thing> cnt = new ArrayList<>();

            @Override
            public boolean offer(Thing thing) {
                cnt.add(thing);
                return true;
            }

            @Override
            public Thing poll() {
                Thing t = cnt.get(ind);
                ind++;
                return t;
            }

            @Override
            public Thing peek() {
                return cnt.get(ind);
            }

            @Override
            public Iterator<Thing> iterator() {
                return null;
            }

            @Override
            public int size() {
                return cnt.size();
            }
        };
        queue.addAll(List.of(devices));
        R r = new R(rigel, queue);
        r.attack();
        System.out.println(devices[0] + " " + devices[0].getCondition().toString());
        */
    }
}