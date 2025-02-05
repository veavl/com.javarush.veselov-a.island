package local;

import creature.animal.Animal;
import creature.plant.Plant;
import util.Settings;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Location {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final int id;
    public Location() {
        id = COUNTER.getAndIncrement();
    }

    private final Queue<Animal> animals = new ConcurrentLinkedQueue<>();

    public Queue<Animal> getAnimals(){
        return animals;
    }

    private final List<Animal>[] arrayListsAnimal = new CopyOnWriteArrayList[Settings.arrayAnimalType.length];

    public  List<Animal>[] getArrayListsAnimal() {
        return arrayListsAnimal;
    }

    private final List<Plant>[] arrayListPlant = new CopyOnWriteArrayList[Settings.arrayPlantType.length];

    public  List<Plant>[] getArrayListPlant() {
        return arrayListPlant;
    }

}
