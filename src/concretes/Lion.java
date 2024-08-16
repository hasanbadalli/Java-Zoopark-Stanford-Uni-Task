package concretes;

import abstracts.BigCat;
import enums.Gender;

import java.util.Arrays;

public class Lion extends BigCat {


    public Lion(Gender gender) {
        super(gender);
    }

    @Override
    public boolean aMonthPasses() {
        return true;
    }


}
