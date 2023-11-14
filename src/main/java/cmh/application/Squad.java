package cmh.application;

import java.util.Random;

public class Squad {
    private final String name;
    private Cop[] members;
    private Cop leader;
    private int destroyPhraseIndex = 0;
    private final String[] destroyPhrases = {"разбили", "разломали", "изрешетили", "разбили"};

    public void moveTo(Location dest, String phrase){
        System.out.println(name + " " + phrase + " " + dest);
        for (Cop member: members){
            member.setLocation(dest);
        }

    }

    public void attack(Thing target){
        this.randomCop().shoot(target);
        if (target.getCondition() == Condition.BROKEN){
            System.out.println(name + " " + destroyPhrases[destroyPhraseIndex] + " " + target);
            destroyPhraseIndex = (destroyPhraseIndex + 1) % destroyPhrases.length;
        } else {
            System.out.println("Пули не нанесли ущерба " + target);
        }
    }

    public void chargePhrase(String phrase){
        System.out.println(name + " " + phrase);
    }

    public Cop randomCop(){
        return members[new Random().nextInt(members.length)];
    }

    public Squad(String name, Cop leader, Cop[] members) {
        this.name = name;
        this.members = members;
        this.leader = leader;
    }

    public Cop[] getMembers() {
        return members;
    }

    public void setMembers(Cop[] members) {
        this.members = members;
    }

    public Cop getLeader() {
        return leader;
    }

    public void setLeader(Cop leader) {
        this.leader = leader;
    }


}
