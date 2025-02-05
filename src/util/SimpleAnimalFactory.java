package util;

import creature.animal.Animal;
import creature.animal.herbivore.*;
import creature.animal.predator.*;

public class SimpleAnimalFactory {

    public Animal returnAnimal(AnimalType animalType) {

        Animal animal = switch (animalType) {
            case WOLF -> new Wolf();
            case BOA -> new Boa();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case PIG -> new Pig();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
            default -> null;
        };
        return animal;
    }
}

