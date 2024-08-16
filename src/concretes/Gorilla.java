package concretes;

import abstracts.Ape;
import enums.Gender;

public class Gorilla extends Ape {

    public Gorilla(Gender gender) {
        super(gender, 32);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {
        painting();
    }

    public void painting(){
        super.increaseHealth(4);
    }

}
