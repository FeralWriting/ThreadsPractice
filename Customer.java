package Assignment12;

import java.util.Random;

public class Customer extends Restaurant implements Runnable{
    int id;
    static int next_customer_id = 1;

    public Customer() {
        id = next_customer_id++;
    }

    public void eatBurger() {
        System.out.println("Customer #" + id + " wants a burger");
        int count = 0;
        for (int i = 0; i < madeFood.size(); i++) {
            if (madeFood.get(i) instanceof Burgers) {
                madeFood.remove(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Oh no, we are out of Burgers!!!");
        }
    }

    public void eatFries() {
        System.out.println("Customer #" + id + " wants a fry");
        int count = 0;
        for (int i = 0; i < madeFood.size(); i++) {
            if (madeFood.get(i) instanceof Fries) {
                madeFood.remove(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Oh no, we are out of Fries!!!");
        }
    }

    public void run() {
        try {
            Random time = new Random();
            Thread.sleep(time.nextInt(1001) + 2000);
            int rand = time.nextInt(4);
            switch (rand) {
                case 0:
                    eatBurger();
                    break;
                case 1:
                    eatBurger();
                    eatFries();
                    break;
                case 2:
                    eatFries();
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println("Grrrr");
        }
    }
}
