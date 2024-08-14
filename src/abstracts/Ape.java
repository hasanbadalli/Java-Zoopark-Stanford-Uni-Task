package abstracts;

import enums.Gender;

public abstract class Ape extends Animal{

    public Ape(Gender gender, int lifeExpectancy) {
        super(gender, new String[]{"fruit", "ice cream"}, lifeExpectancy);
    }
}
