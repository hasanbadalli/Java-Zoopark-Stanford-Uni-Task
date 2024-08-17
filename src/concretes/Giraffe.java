package concretes;

import abstracts.Animal;
import enums.Gender;

public class Giraffe extends Animal {

    public Giraffe(Gender gender) {
        super(gender, new String[]{"hay", "fruit"}, 28);
    }



    @Override
    public void treat() {
        neckMassage();
    }

    public void neckMassage(){
        super.increaseHealth(4);
    }

    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Giraffe had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Giraffe health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }
}
