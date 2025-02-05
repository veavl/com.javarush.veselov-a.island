package util;

import creature.plant.Grass;
import creature.plant.Plant;
import creature.plant.Shrub;

public class SimplePlantFactory {

    public Plant returnPlant(PlantType plantType) {

        Plant plant = switch(plantType) {
            case GRASS -> new Grass();
            case SHRUB -> new Shrub();
        };
        return plant;
    }
}