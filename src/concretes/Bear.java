package concretes;

import abstracts.Animal;
import enums.Gender;

public class Bear extends Animal {
    public Bear(Gender gender) {
        super(gender, new String[]{"fish", "steak"}, 18);
    }


    @Override
    public void treat() {
        hug();
    }

    public void hug(){
        increaseHealth(2);
    }

    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Bear had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Bear health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
