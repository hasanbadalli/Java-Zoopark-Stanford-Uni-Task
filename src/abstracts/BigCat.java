package abstracts;

import enums.Gender;

public abstract class BigCat extends Animal {

    public BigCat(Gender gender) {
        super(gender, new String[]{"steak", "celery"}, 24);
    }
}
