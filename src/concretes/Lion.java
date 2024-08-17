package concretes;

import abstracts.BigCat;
import enums.Gender;

import java.util.Arrays;

public class Lion extends BigCat {


    public Lion(Gender gender) {
        super(gender);
    }

    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Lion had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Lion health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
