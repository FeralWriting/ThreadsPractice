package Assignment12;

import java.util.Random;

public class BurgerCook extends Restaurant implements Runnable{
    int id;
    static int next_burgercook_id = 1;

    public BurgerCook() {
        id = next_burgercook_id++;
    }

    public void run() {
        System.out.println("Burger cooker #" + id + " is starting to cook");
        for (int i = 0; i < 50; i++) {
            System.out.println("Burger cooker #" + id + " cooked a burger");
            madeFood.add(new Burgers());
            try {
                Random num = new Random();
                Thread.sleep(num.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Bumpkins");
            }
        }
    }
}
