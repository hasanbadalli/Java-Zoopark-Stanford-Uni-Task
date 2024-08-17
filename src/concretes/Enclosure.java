package concretes;

import abstracts.Animal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Enclosure {
    private FoodStore foodStore = new FoodStore();
    private int waste = 0;

    private List<Animal> animals;

    public Enclosure(List<Animal> animals) {
        this.animals = animals;
    }




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
            System.out.println("Waste removed.");
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
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            animal.aMonthPasses();


            if(animal.getHealth() <= 0 || animal.getAge() > animal.getLifeExpectancy()) {
                iterator.remove();
            }
        }

        System.out.println("---");
        System.out.println("Waste " + waste);
        removeWaste(getWasteSize());
        System.out.println("---");
    }


    public List<Animal> getAnimals() {
        return animals;
    }
}
