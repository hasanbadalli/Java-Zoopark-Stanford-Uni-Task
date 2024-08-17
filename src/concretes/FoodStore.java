package concretes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodStore {
    private HashMap<String, Integer> foodStorage = new HashMap<>();
    private HashMap<String, Integer> foodHealthValues = new HashMap<>();
    private HashMap<String, Integer> foodWasteValues = new HashMap<>();

    public FoodStore() {
        foodHealthValues.put("hay", 1);
        foodWasteValues.put("hay", 4);

        foodHealthValues.put("steak", 3);
        foodWasteValues.put("steak", 4);

        foodHealthValues.put("fruit", 2);
        foodWasteValues.put("fruit", 3);

        foodHealthValues.put("celery", 0);
        foodWasteValues.put("celery", 1);

        foodHealthValues.put("fish", 3);
        foodWasteValues.put("fish", 2);

        foodHealthValues.put("ice cream", 1);
        foodWasteValues.put("ice cream", 3);
    }
    public void addFood(String food, int quantity) {
        foodStorage.put(food, foodStorage.getOrDefault(food, 0) + quantity);
    }

    public void takeFood(String food) {
        if(foodStorage.containsKey(food) && foodStorage.get(food) > 0) {
            foodStorage.put(food, foodStorage.get(food) - 1);

        }else{
            throw new IllegalArgumentException("Food is either not available or out of stock.");
        }
    }

    public void takeFood(String food, int quantity) {
        if (foodStorage.containsKey(food) && foodStorage.get(food) >= quantity) {
            foodStorage.put(food, foodStorage.get(food) - quantity);
        } else {
            throw new IllegalArgumentException("Food is either not available or not enough in stock.");
        }
    }


    public int getHealthValue(String food) {
        return foodHealthValues.getOrDefault(food, 0);
    }
    public int getWasteValue(String food) {
        return foodWasteValues.getOrDefault(food, 0);
    }
    public int getFoodQuantity(String food) {
        return foodStorage.getOrDefault(food, 0);
    }

    public List<String> getAvailableFoods() {
        List<String> availableFoods = new ArrayList<>();
        for (String food : foodStorage.keySet()) {
            if (foodStorage.get(food) > 0) {
                availableFoods.add(food);
            }
        }
        return availableFoods;
    }
}
