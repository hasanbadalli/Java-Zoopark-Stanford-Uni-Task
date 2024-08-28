import abstracts.Animal;

import concretes.*;
import enums.Gender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*FoodStore zooFoodStore = new FoodStore();
        zooFoodStore.addFood("hay", 50);
        zooFoodStore.addFood("fruit", 50);
        zooFoodStore.addFood("steak", 50);
        zooFoodStore.addFood("fish", 50);



        Animal lion1 = new Lion(Gender.FEMALE);
        Animal lion2 = new Lion(Gender.FEMALE);
        Animal lion3 = new Lion(Gender.FEMALE);
        Animal tiger1 = new Tiger(Gender.MALE);


        Enclosure bigCatEnclosure = new Enclosure(new ArrayList<>());
        *//*lion1.setEnclosure(bigCatEnclosure);
        lion2.setEnclosure(bigCatEnclosure);
        lion3.setEnclosure(bigCatEnclosure);
        tiger1.setEnclosure(bigCatEnclosure);*//*
        bigCatEnclosure.addAnimal(lion1);
        bigCatEnclosure.addAnimal(lion2);
        bigCatEnclosure.addAnimal(lion3);
        bigCatEnclosure.addAnimal(tiger1);


        Elephant elephant1 = new Elephant(Gender.MALE);
        Elephant elephant2 = new Elephant(Gender.FEMALE);
        Enclosure elephantEnclosure = new Enclosure(new ArrayList<>());
        elephantEnclosure.addAnimal(elephant1);
        elephantEnclosure.addAnimal(elephant2);

        Zookeeper generalZookeeper1 = new Zookeeper(bigCatEnclosure, zooFoodStore);
        Zookeeper generalZookeeper2 = new Zookeeper(elephantEnclosure, zooFoodStore);

        Zoo zoo = new Zoo(new ArrayList<>(Arrays.asList(bigCatEnclosure, elephantEnclosure)),
                new ArrayList<>(Arrays.asList(generalZookeeper1, generalZookeeper2)));
        zoo.go(28);
*/


        if (args.length != 1) {
            System.out.println("Usage: java Zoo <config-file>");
            return;
        }

        String configFile = args[0];
        Zoo zoo = new Zoo();
        zoo.loadConfiguration(configFile);


        zoo.go(28);
    }
}