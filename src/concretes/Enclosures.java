package concretes;

import abstracts.Animal;

import java.util.ArrayList;

public class Enclosures {
    private FoodStore foodStore = new FoodStore();
    private int waste = 0;

    ArrayList<Animal> animals = new ArrayList<>();


    public void addAnimal(Animal animal) {
        if (animals.size() < 20) {
            animals.add(animal);
            animal.setEnclosure(this);
        } else {
            System.out.println("Enclosure is full! Cannot add more animals.");
        }
    }

    public void removeAniaml(Animal animal) {
        animals.remove(animal);
    }

    public void removeWaste(int amount) {
        if (waste >= amount) {
            waste -= amount;
        }else{
            System.out.println("Not enough waste to remove!");
        }
    }

    public void addWaste(int amount) {
        waste += amount;
    }


    public FoodStore getFoodStore(){
        return foodStore;
    }

    public int getWasteSize(){
        return waste;
    }

    public int size(){
        return animals.size();
    }

    public void aMonthPasses(){
        //TODO
        animals.forEach(Animal::aMonthPasses);
    }

}
