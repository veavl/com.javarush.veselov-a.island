import local.Island;
import util.Settings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Island island = new Island(Settings.height, Settings.weight);
        //Заселяем остров
        Island.populateIsland(island);

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        System.out.println("НАЧАЛЬНОЕ ЧИСЛО СУЩНОСТЕЙ - ПОСЛЕ ЗАСЕЛЕНИЯ ОСТРОВА");
        island.display();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Island.runLife(island);
                    System.out.println("ВСЕГО ОСТАЛОСЬ животных и растений");
                    island.display();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        for (int i = 0; i < Settings.lifeCycle; i++) {
            threadPool.execute(runnable2);
            Thread.sleep(1000);
        }
        threadPool.shutdown();
    }
}