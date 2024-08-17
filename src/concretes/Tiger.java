package concretes;

import abstracts.BigCat;
import enums.Gender;

public class Tiger extends BigCat {


    public Tiger(Gender gender) {
        super(gender);
    }


    @Override
    public void stroked() {
        increaseHealth(3);
    }

    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Tiger had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Tiger health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
