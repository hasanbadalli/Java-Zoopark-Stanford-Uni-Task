package concretes;

import abstracts.Animal;
import enums.Gender;

public class Elephant extends Animal {

    public Elephant(Gender gender) {
        super(gender, new String[]{"hay", "fruit"}, 36);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {

    }
}
