package concretes;

import abstracts.BigCat;
import enums.Gender;

public class Tiger extends BigCat {


    public Tiger(Gender gender) {
        super(gender);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    @Override
    public void treat() {

    }

}
