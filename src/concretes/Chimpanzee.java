package concretes;

import abstracts.Ape;
import enums.Gender;

public class Chimpanzee extends Ape {

    public Chimpanzee(Gender gender) {
        super(gender, 24);
    }


    @Override
    public void treat() {
        playChase();
    }

    public void playChase(){
        super.increaseHealth(4);
    }
    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Chimpanzee had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Chimpanzee health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }


}
