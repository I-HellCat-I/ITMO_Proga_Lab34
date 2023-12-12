package cmh;

import java.util.ArrayList;

@Significance(TypeOfSignificance.SIGNIFICANT)
public class Medic extends Human{
    Medic(String n){
        super(n);
    }
    void fastHealthCheck(Human trg){
        if (trg.getWounds().size() > 0){
            System.out.println(this + " увидел, что " + trg + " ранен.");
        } else {
            System.out.println(this + " увидел, что " + trg + " здоров.");
        }
    }
    void healthCheck(Human trg){
        if (trg.getWounds().size() > 0){
            trg.getWounds().forEach((a) -> System.out.println("Осмотрев рану, " + this + " установил, что " + a + "."));
        }
    }


    public void heal(Human trg, String healPhr) {
        trg.setWounds(new ArrayList<>());
        System.out.println(this + healPhr);
    }
}
