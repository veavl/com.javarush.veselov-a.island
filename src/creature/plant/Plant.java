package creature.plant;

import creature.Creature;
import local.Location;
//import util.AnimalType;
//import util.PlantType;

import java.util.Random;

public class Plant extends Creature {

    public String icon;
    public int weight;
    public int maxCountInCell;
    // public PlantType type;

    public Plant(int weight, int maxCountInCell) {
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
    }

    public String getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }
}
