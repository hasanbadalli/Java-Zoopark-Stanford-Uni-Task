package abstracts;

import concretes.Enclosures;
import concretes.FoodStore;
import enums.Gender;

import java.util.Arrays;

public abstract class Animal {
    private int age;
    private Gender gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;
    private Enclosures enclosure;

    public Animal(Gender gender, String[] eats,int lifeExpectancy) {
        this.age = 0;
        this.health = 10;
        this.gender = gender;
        this.eats = eats;
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setEnclosure(Enclosures enclosure) {
        this.enclosure = enclosure;
    }

    public Enclosures getEnclosures(){
        return this.enclosure;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public boolean canEat(String food){
        return Arrays.stream(eats).anyMatch(e -> e.contains(food));
    }

    public FoodStore getFoodStore(){
        if(enclosure == null){
            return enclosure.getFoodStore();
        }
        return null;
    }

    public void eat(String food){}

    public void decraseHealth(int health){}

    public void treat(String food){}

    public abstract boolean aMonthPasses();

    public abstract void treat();
}
