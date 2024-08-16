package concretes;

import abstracts.Animal;
import enums.Gender;

public class Penguin extends Animal {

    public Penguin(Gender gender) {
        super(gender, new String[]{"fish", "ice cream"}, 15);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {
        watchaFilm();
    }

    public void watchaFilm(){
        super.increaseHealth(2);
    }

}
