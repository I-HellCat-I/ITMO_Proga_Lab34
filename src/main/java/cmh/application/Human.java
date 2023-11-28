package cmh.application;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


public class Human extends Entity {
    public void endure() {
        System.out.println(this + " терпеливо переносил боль.");
    }

    public void noticeShooting(){
        onNoticeShootingListener.notify(this);
    }

    public void setOnNoticeShootingListener(Listener l){
        this.onNoticeShootingListener = l;
    }

    public void setHeldDevice(Device device) {
        heldDevice = device;
    }

    public Device getHeldDevice() {
        return heldDevice;
    }


    class Wound{
        private String name;
        private String comments;
        Wound(String n, String c){
            name = n;
            comments = c;
        }

        @Override
        public String toString() {
            return name + ", " + comments;
        }
    }
    private static int humanAmount = 0;
    private ArrayList<Wound> wounds = new ArrayList<>();

    private Device heldDevice;
    private Listener onNoticeShootingListener;


    public Human(String name) {
        super(name);
        humanAmount++;
    }

    public Human() {
        super(""+ humanAmount);
        humanAmount++;
    }
    public void addWound(String n, String c){
        wounds.add(new Wound(n, c));
    }
    public void setWounds(ArrayList<Wound> ws){
        wounds = ws;
    }
    public ArrayList<Wound> getWounds(){
        return wounds;
    }

    public void shout(String phrase){
        System.out.println(name + " закричал: " + phrase);
    }
    public void customSpeech(String phrase){
        System.out.println(phrase);
    }
    public void say(String phrase){
        System.out.println(this + " сказал " + phrase);
    }
    @Override
    public String toString() {
        return "Человек " + name;
    }
}
