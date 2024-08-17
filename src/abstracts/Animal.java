package abstracts;

import concretes.Enclosure;
import concretes.FoodStore;
import enums.Gender;

import java.util.Arrays;

public abstract class Animal {
    private int age;
    private Gender gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;
    private Enclosure enclosure;

    public Animal(Gender gender, String[] eats,int lifeExpectancy) {
        this.age = 0;
        this.health = 10;
        this.gender = gender;
        this.eats = eats;
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public Enclosure getEnclosures(){
        return this.enclosure;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public boolean canEat(String food){
        return Arrays.stream(eats).anyMatch(e -> e.contains(food));
    }

    public FoodStore getFoodStore(){
        if(enclosure != null){
            return enclosure.getFoodStore();
        }
        return null;
    }

    public int getHealth() {
        return health;
    }

    public void eat(){

        try{
            FoodStore foodStore = getFoodStore();
            if(foodStore == null){
                System.out.println("No food store avialable for this animal enclosure");
                return;
            }
            boolean hafeFood = false;
            for (String food : eats) {
                if(foodStore.getFoodQuantity(food) > 0){
                    foodStore.takeFood(food);
                    health += foodStore.getHealthValue(food);
                    if(health>10){
                        health = 10;
                    }
                    enclosure.addWaste(foodStore.getWasteValue(food));
                    System.out.println("Animal eat: " + food);
                    hafeFood = true;
                    break;
                }

            }



            if(!hafeFood){
                decraseHealth();
                System.out.println("Animal did not find suitable food and lost health.");
            }
        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
        }


    }

    public void decraseHealth(){
        health -= 2;
    }

    public void increaseHealth(int value){
        health += value;
    }

    public abstract boolean aMonthPasses();

    public abstract void treat();
}
