package concretes;

public class Zoo {
    private Enclosure[] enclosures;
    private FoodStore foodStore;

    public Zoo(Enclosure[] enclosures) {
        this.enclosures = enclosures;
        this.foodStore = new FoodStore();
    }

    public void aMonthPasses(){
        for (Enclosure enclosure : enclosures) {
            System.out.println("-------------------");
            enclosure.aMonthPasses();
            System.out.println("-------------------");
        }

        restockFood();
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
