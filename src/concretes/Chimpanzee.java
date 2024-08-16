package concretes;

import abstracts.Ape;
import enums.Gender;

public class Chimpanzee extends Ape {

    public Chimpanzee(Gender gender) {
        super(gender, 24);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {
        playChase();
    }

    public void playChase(){
        super.increaseHealth(4);
    }

}
