package concretes;

import abstracts.Animal;
import enums.Gender;

public class Elephant extends Animal {

    public Elephant(Gender gender) {
        super(gender, new String[]{"hay", "fruit"}, 36);
    }


    @Override
    public void treat() {
        bath();
    }

    public void bath(){
        super.increaseHealth(5);
    }

    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Elephant had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Elephant health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
