package Assignment12;

import java.util.Random;

public class FryCook extends Restaurant implements Runnable{
    int id;
    static int next_frycook_id = 1;

    public FryCook() {
        id = next_frycook_id++;
    }

    public void run() {
        System.out.println("Fry cooker #" + id + " is starting to cook");
        for (int i = 0; i < 50; i++) {
            System.out.println("Fry cooker #" + id + " cooked a fry");
            madeFood.add(new Fries());
            try {
                Random num = new Random();
                Thread.sleep(num.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Frimpkins");
            }
        }
    }
}
