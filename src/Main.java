import abstracts.Animal;

import concretes.Enclosure;
import concretes.Lion;
import concretes.Tiger;
import concretes.Zoo;
import enums.Gender;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> bigCats = new ArrayList<>();
        Animal lion1 = new Lion(Gender.FEMALE);
        Animal lion2 = new Lion(Gender.FEMALE);
        Animal lion3 = new Lion(Gender.FEMALE);
        Animal tiger1 = new Tiger(Gender.MALE);
        bigCats.add(lion1);
        bigCats.add(lion2);
        bigCats.add(lion3);
        bigCats.add(tiger1);

        Enclosure bigCatEnclosure = new Enclosure(bigCats);
        lion1.setEnclosure(bigCatEnclosure);
        lion2.setEnclosure(bigCatEnclosure);
        lion3.setEnclosure(bigCatEnclosure);
        tiger1.setEnclosure(bigCatEnclosure);

        Enclosure[] enclosures = {bigCatEnclosure};

        Zoo zoo = new Zoo(enclosures);
        zoo.go(28);
    }
}