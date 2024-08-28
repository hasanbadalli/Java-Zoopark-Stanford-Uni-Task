package concretes;

import abstracts.Animal;
import enums.Gender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Zoo {
    private List<Enclosure> enclosures;
    private List<Zookeeper> zookeepers;
    private FoodStore foodStore;

    public Zoo(List<Enclosure> enclosures, List<Zookeeper> zookeepers) {
        this.enclosures = enclosures;
        this.zookeepers = zookeepers;
        this.foodStore = new FoodStore();
    }

    public Zoo(){

    }
    public void loadConfiguration(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Enclosure currentEnclosure = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("zoo:")) {
                    continue;
                } else if (line.contains(":")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0];
                        int value = Integer.parseInt(parts[1]);

                        if (key.equals("enclosure")) {

                            currentEnclosure = new Enclosure(value);
                            enclosures.add(currentEnclosure);
                        } else if (currentEnclosure == null) {

                            foodStore.addFood(key, value);
                        } else {

                            currentEnclosure.getFoodStore().addFood(key, value);
                        }
                    }
                } else if (line.startsWith("lion") || line.startsWith("elephant")) {

                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String type = parts[0];
                        String[] animalData = parts[1].split(",");

                        if (animalData.length >= 3) {
                            Gender gender = Gender.valueOf(animalData[0]);
                            int age = Integer.parseInt(animalData[1]);
                            int health = Integer.parseInt(animalData[2]);

                            Animal animal = createAnimal(type, gender, age, health);

                            if (animal != null && currentEnclosure != null) {
                                animal.setEnclosure(currentEnclosure);
                                currentEnclosure.addAnimal(animal);
                            }
                        }
                    }
                } else if (line.startsWith("playZookeeper")) {

                    Zookeeper zooKeeper = new Zookeeper();
                    if (currentEnclosure != null) {
                        zooKeeper.setEnclosure(currentEnclosure);
                    }
                    zookeepers.add(zooKeeper);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Animal createAnimal(String type, Gender gender, int age, int health) {
        switch (type.toLowerCase()) {
            case "lion":
                return new Lion(gender);
            case "elephant":
                return new Elephant(gender);
            default:
                return null;
        }
    }

    public void aMonthPasses(){
        int next = 1;
        for (Enclosure enclosure : enclosures) {
            System.out.println("-------------------");
            System.out.println(next+". Enclosure");
            next++;
            enclosure.aMonthPasses();
            System.out.println("-------------------");
        }

        next =1;
        for (Zookeeper zookeeper : zookeepers) {
            System.out.println("-------------------");
            System.out.println(next+". Zookeeper");
            next++;
            zookeeper.aMonthPasses();
            System.out.println("-------------------");
        }

        //restockFood();
    }

    public void addZookeeper(Zookeeper zookeeper) {
        zookeepers.add(zookeeper);
    }

    public void go(int months){
        for (int i = 0; i < months; i++) {
            System.out.println("Month " + (i+1) + " in the zoo:");
            aMonthPasses();

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public void restockFood() {
        for (Enclosure enclosure : enclosures) {

            enclosure.getFoodStore().addFood("hay", 10);
            enclosure.getFoodStore().addFood("steak", 5);
            enclosure.getFoodStore().addFood("fruit", 8);
            enclosure.getFoodStore().addFood("celery", 7);
            enclosure.getFoodStore().addFood("fish", 6);
            enclosure.getFoodStore().addFood("ice cream", 3);

            System.out.println("Food store has been restocked.");
        }

    }
}
