package ThreadsPractice;

public class Main {
    public static void main(String[] args) {
        Restaurant stingers = new Restaurant();
        System.out.println("We are open!");
        stingers.open();
        stingers.openDoors();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                stingers.currentCookedFood();
            } catch (Exception e) {
                System.out.println("literally why");
            }
        }
        System.out.println("We are closed");
    }
}
