package Assignment12;

import java.util.ArrayList;

public class Restaurant {
    static ArrayList<Food> madeFood = new ArrayList<>();
    ArrayList<Thread> workers = new ArrayList<>();
    ArrayList<Thread> customers = new ArrayList<>();

    public void open() {
        for (int i = 0; i < 4; i++) {
            workers.add(new Thread(new FryCook()));
            workers.get(i).start();
        }
        for (int i = 4; i < 7; i++) {
            workers.add(new Thread(new BurgerCook()));
            workers.get(i).start();
        }
    }

    public void openDoors() {
        for (int i = 0; i < 100; i++) {
            customers.add(new Thread(new Customer()));
            System.out.println("Customer " + (i + 1) + " has shown up");
            customers.get(i).start();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Gunk");
            }
        }
    }

    public void currentCookedFood() {
        int borgerCount = 0;
        int fryCount = 0;
        for (int i = 0; i < madeFood.size(); i++) {
            if (madeFood.get(i) instanceof Burgers) {
                borgerCount++;
            } else {
                fryCount++;
            }
        }
        System.out.println("Currently: " + madeFood.size() + " items");
        System.out.println("Currently we have " + fryCount + " fries, and " + borgerCount + " burgers");
    }
}
