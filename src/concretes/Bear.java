package concretes;

import abstracts.Animal;
import enums.Gender;

public class Bear extends Animal {
    public Bear(Gender gender) {
        super(gender, new String[]{"fish", "steak"}, 18);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {

    }
}
