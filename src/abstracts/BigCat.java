package abstracts;

import enums.Gender;

public abstract class BigCat extends Animal {

    public BigCat(Gender gender) {
        super(gender, new String[]{"steak", "celery"}, 24);
    }

    @Override
    public void treat() {
        stroked();
    }

    public void stroked(){
        super.increaseHealth(2);
    }
}
