package concretes;

import abstracts.Ape;
import enums.Gender;

public class Gorilla extends Ape {

    public Gorilla(Gender gender) {
        super(gender, 32);
    }



    @Override
    public void treat() {
        painting();
    }

    public void painting(){
        super.increaseHealth(4);
    }

    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Gorilla had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Gorilla health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
