package cmh.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Squad {
    private final String name;
    //private Cop[] members;
    private ArrayList<Cop> members = new ArrayList<>();
    private Cop leader;
    private int destroyPhraseIndex = 0;
    private static int inTheAirPhraseIndex = 4;
    private final String[] destroyPhrases = {"разбили", "разломали", "изрешетили", "разбили"};


    public void moveTo(Location dest, String phrase){
        System.out.println(name + " " + phrase + " " + dest);
        for (Cop member: members){
            if (member.isOnTheGround()){
                member.setLocation(dest);
            }
        }

    }

    public void attack(Thing target){
        if (checkIfSquadInAir()){
            class InTheAirPhaseGiver{
                public static final String[] inTheAirPhrases = {"беспомощно кувыркаются в воздухе", "безалаберно размахивают руками",
                        "брыкаяются ногами", "вихляются всем телом"};
                public static String giveInTheAirPhrase() {
                    inTheAirPhraseIndex = (inTheAirPhraseIndex + 1) % inTheAirPhrases.length;
                    return inTheAirPhrases[inTheAirPhraseIndex];
                }
            }
            System.out.println(name + " " + InTheAirPhaseGiver.giveInTheAirPhrase());
            return;
        }
        this.randomCop().shoot(target);
        if (target.getCondition() == Condition.BROKEN){
            System.out.println(name + " " + destroyPhrases[destroyPhraseIndex] + " " + target);
            destroyPhraseIndex = (destroyPhraseIndex + 1) % destroyPhrases.length;
        } else {
            System.out.println("Пули не нанесли ущерба " + target);
        }
    }
    public void inTheAirReaction(){
        if (checkIfSquadInAir()){
            System.out.println(name + " почувствовали, что почва ушла из-под их ног.");
            confused();
        } else {
            throw new unchecked(name + " не в воздухе");
        }
    }

    private void confused() {
        System.out.println(name + " не в силах понять, что происходит");
    }

    public boolean checkIfSquadInAir(){
        boolean flag = true;
        for (Cop c: members){
            flag = flag && !c.isOnTheGround();
        }
        return flag;
    }

    public void chargePhrase(String phrase){
        System.out.println(name + " " + phrase);
    }

    public Cop randomCop(){
        return members.get(new Random().nextInt(members.size()));
    }

    public Squad(String name, Cop leader, ArrayList<Cop> members) {
        this.name = name;
        this.members = members;
        this.leader = leader;
    }
    public Squad(String name, Cop leader, Cop[] members) {
        this.name = name;
        this.members.addAll(Arrays.asList(members));
        this.leader = leader;
    }

    public ArrayList<Cop> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Cop> members) {
        this.members = members;
    }

    public Cop getLeader() {
        return leader;
    }

    public void setLeader(Cop leader) {
        this.leader = leader;
    }

    public void callOver(){
        members.forEach(c -> c.shout("Здесь!"));
    }
}
