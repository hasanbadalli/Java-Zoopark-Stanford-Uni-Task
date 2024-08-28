package concretes;

import abstracts.Animal;

import java.util.List;

public class Zookeeper {
    private Enclosure enclosure;
    private FoodStore zooFoodStore;

    public Zookeeper(Enclosure enclosure, FoodStore zooFoodStore) {
        this.enclosure = enclosure;
        this.zooFoodStore = zooFoodStore;
    }

    public Zookeeper(){}

    public void aMonthPasses() {

        moveFood();


        removeWaste();

        treatAnimals();
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void setZooFoodStore(FoodStore zooFoodStore) {
        this.zooFoodStore = zooFoodStore;
    }

    protected void moveFood() {
        FoodStore enclosureFoodStore = enclosure.getFoodStore();
        int foodMoved = 0;

        for (String food : zooFoodStore.getAvailableFoods()) {
            int quantity = zooFoodStore.getFoodQuantity(food);
            if (quantity > 0) {
                int moveQuantity = Math.min(20 - foodMoved, quantity);
                enclosureFoodStore.addFood(food, moveQuantity);
                zooFoodStore.takeFood(food, moveQuantity);
                foodMoved += moveQuantity;

                if (foodMoved >= 20) break;
            }
        }
    }

    protected void removeWaste() {
        int wasteToRemove = Math.min(20, enclosure.getWasteSize());
        enclosure.removeWaste(wasteToRemove);
        System.out.println("Removed " + wasteToRemove + " units of waste from the enclosure.");
    }

    protected void treatAnimals() {
        List<Animal> animals = enclosure.getAnimals();
        for (int i = 0; i < Math.min(2, animals.size()); i++) {
            Animal animal = animals.get(i);
            System.out.println("Generic Zookeeper treating animal.");
            animal.treat();
        }
    }
}

