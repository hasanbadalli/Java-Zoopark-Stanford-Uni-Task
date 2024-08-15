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

    public void eat(){

        try{
            FoodStore foodStore = getFoodStore();
            if(foodStore == null){
                System.out.println("No food store avialable for this animal enclosure");
                return;
            }

            for (String food : eats) {
                if(foodStore.getFoodQuantity(food) > 0){
                    foodStore.takeFood(food);
                    health += foodStore.getHealthValue(food);
                    enclosure.addWaste(foodStore.getWasteValue(food));
                    System.out.println("Animal eaten " + food + " Health increase: " + foodStore.getHealthValue(food) + " waste: " + foodStore.getWasteValue(food));
                }
            }


            System.out.println("No suitable food available for this animal to eat.");

        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
        }


    }

    public void decraseHealth(){
        health -= 2;
    }

    public abstract boolean aMonthPasses();

    public abstract void treat();
}
