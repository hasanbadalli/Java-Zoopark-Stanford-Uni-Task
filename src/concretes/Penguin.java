package concretes;

import abstracts.Animal;
import enums.Gender;

public class Penguin extends Animal {

    public Penguin(Gender gender) {
        super(gender, new String[]{"fish", "ice cream"}, 15);
    }


    @Override
    public void treat() {
        watchaFilm();
    }

    public void watchaFilm(){
        super.increaseHealth(2);
    }

    @Override
    public boolean aMonthPasses(){
        int age = getAge();
        setAge(++age);


        eat();
        if(age > getLifeExpectancy() || getHealth() <= 0){
            System.out.println("Sorry... Penguin had died. Age: " + getAge() + " Health: " + getHealth());
            return false;
        }
        System.out.println("Penguin health: " + getHealth() + " age: " + getAge());
        System.out.println();



        return true;
    }

}
