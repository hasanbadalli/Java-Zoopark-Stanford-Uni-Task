package concretes;

import abstracts.Animal;
import enums.Gender;

public class Giraffe extends Animal {

    public Giraffe(Gender gender) {
        super(gender, new String[]{"hay", "fruit"}, 28);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {

    }
}
