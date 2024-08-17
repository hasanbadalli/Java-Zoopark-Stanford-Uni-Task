package concretes;

import java.util.List;

public class Zoo {
    private List<Enclosure> enclosures;
    private List<Zookeeper> zookeepers;
    private FoodStore foodStore;

    public Zoo(List<Enclosure> enclosures, List<Zookeeper> zookeepers) {
        this.enclosures = enclosures;
        this.zookeepers = zookeepers;
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
