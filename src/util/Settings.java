package util;

import creature.animal.Animal;
import creature.plant.Plant;
import java.util.*;
import static util.AnimalType.*;
import static util.PlantType.*;

public class Settings {

    public static final int height = 100;
    public static final int weight = 20;
    public static final int lifeCycle = 100;

    public static AnimalType[] arrayAnimalType = AnimalType.values();                         // КОНСТАНТЫ AnimalType
    public static PlantType[] arrayPlantType = PlantType.values();                            // КОНСТАНТЫ PlantType


// Получаем AnimalType по getClass()
    public static Map<String, AnimalType> getType = new HashMap<>() {
        {
           put("creature.animal.predator.Wolf", WOLF);
           put("creature.animal.predator.Boa", BOA);
           put("creature.animal.predator.Fox", FOX);
           put("creature.animal.predator.Bear", BEAR);
           put("creature.animal.predator.Eagle", EAGLE);
           put("creature.animal.herbivore.Horse", HORSE);
           put("creature.animal.herbivore.Deer", DEER);
           put("creature.animal.herbivore.Rabbit", RABBIT);
           put("creature.animal.herbivore.Mouse", MOUSE);
           put("creature.animal.herbivore.Goat", GOAT);
           put("creature.animal.herbivore.Sheep", SHEEP);
           put("creature.animal.herbivore.Pig", PIG);
           put("creature.animal.herbivore.Buffalo", BUFFALO);
           put("creature.animal.herbivore.Duck", DUCK);
           put("creature.animal.herbivore.Caterpillar", CATERPILLAR);
        }
    };

    public static Map<String, PlantType> getPlantType = new HashMap<>() {
        {
            put("creature.plant.Grass", GRASS);
            put("creature.plant.Shrub", SHRUB);
        }
    };

    public static AnimalType getType (Animal animal) {              // Получаем по objectAnimal.getClass().getName())
        return getType.get(animal.getClass().getName());
    }

    public static PlantType getPlantType (Plant plant) {            // Получаем PlantType по objectPlant.getClass().getName())
        return getPlantType.get(plant.getClass().getName());
    }

    public static int getConstantNumber(AnimalType animalType) {
        return animalType.ordinal();
    }

    //--------------- ВОЛК -------------------------------------------------
    public static Map<AnimalType, Integer> wolfMap = new HashMap<>() {
        {
            put(WOLF, null);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 10);
            put(DEER, 15);
            put(RABBIT, 60);
            put(MOUSE, 80);
            put(GOAT, 60);
            put(SHEEP, 70);
            put(PIG, 15);
            put(BUFFALO, 10);
            put(DUCK, 40);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> wolfMapPlant = new HashMap<>() {
        {
            put(GRASS, 0);
            put(SHRUB, 0);
        }
    };

    //--------------- УДАВ -------------------------------------------------
    public static Map<AnimalType, Integer> boaMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, null);
            put(FOX, 15);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 20);
            put(MOUSE, 40);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 10);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> boaMapPlant = new HashMap<>() {
        {
            put(GRASS, 0);
            put(SHRUB, 0);
        }
    };

    //--------------- ЛИСА -------------------------------------------------
    public static Map<AnimalType, Integer> foxMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, null);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 70);
            put(MOUSE, 90);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 60);
            put(CATERPILLAR, 40);
        }
    };
    public static Map<PlantType, Integer> foxMapPlant = new HashMap<>() {
        {
            put(GRASS, 0);
            put(SHRUB, 0);
        }
    };

    //--------------- МЕДВЕДЬ -------------------------------------------------
    public static Map<AnimalType, Integer> bearMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 80);
            put(FOX, 0);
            put(BEAR, null);
            put(EAGLE, 0);
            put(HORSE, 40);
            put(DEER, 80);
            put(RABBIT, 80);
            put(MOUSE, 90);
            put(GOAT, 70);
            put(SHEEP, 70);
            put(PIG, 50);
            put(BUFFALO, 20);
            put(DUCK, 10);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> bearMapPlant = new HashMap<>() {
        {
            put(GRASS, 0);
            put(SHRUB, 0);
        }
    };

    //--------------- ОРЕЛ -------------------------------------------------
    public static Map<AnimalType, Integer> eagleMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 10);
            put(BEAR, 0);
            put(EAGLE, null);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 90);
            put(MOUSE, 90);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 80);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> eagleMapPlant = new HashMap<>() {
        {
            put(GRASS, 0);
            put(SHRUB, 0);
        }
    };

    //--------------- ЛОШАДЬ -------------------------------------------------
    public static Map<AnimalType, Integer> horseMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, null);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> horseMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- ОЛЕНЬ -------------------------------------------------
    public static Map<AnimalType, Integer> deerMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, null);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> deerMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- КРОЛИК -------------------------------------------------
    public static Map<AnimalType, Integer> rabbitMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(RABBIT, null);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> rabbitMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- МЫШЬ -------------------------------------------------
    public static Map<AnimalType, Integer> mouseMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(RABBIT, 0);
            put(MOUSE, null);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 90);
        }
    };
    public static Map<PlantType, Integer> mouseMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- КОЗА -------------------------------------------------
    public static Map<AnimalType, Integer> goatMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, null);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> goatMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- ОВЦА -------------------------------------------------
    public static Map<AnimalType, Integer> sheepMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, null);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> sheepMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- КАБАН -------------------------------------------------
    public static Map<AnimalType, Integer> pigMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(RABBIT, 0);
            put(MOUSE, 50);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, null);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, 90);
        }
    };
    public static Map<PlantType, Integer> pigMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- БУЙВОЛ -------------------------------------------------
    public static Map<AnimalType, Integer> buffaloMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, null);
            put(DUCK, 0);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> buffaloMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- УТКА -------------------------------------------------
    public static Map<AnimalType, Integer> duckMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, null);
            put(CATERPILLAR, 0);
        }
    };
    public static Map<PlantType, Integer> duckMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //--------------- ГУСЕНИЦА -------------------------------------------------
    public static Map<AnimalType, Integer> caterpillarMap = new HashMap<>() {
        {
            put(WOLF, 0);
            put(BOA, 0);
            put(FOX, 0);
            put(BEAR, 0);
            put(EAGLE, 0);
            put(HORSE, 0);
            put(DEER, 0);
            put(RABBIT, 0);
            put(MOUSE, 0);
            put(GOAT, 0);
            put(SHEEP, 0);
            put(PIG, 0);
            put(BUFFALO, 0);
            put(DUCK, 0);
            put(CATERPILLAR, null);
        }
    };
    public static Map<PlantType, Integer> caterpillarMapPlant = new HashMap<>() {
        {
            put(GRASS, 100);
            put(SHRUB, 100);
        }
    };

    //---------------  -------------------------------------------------
    public static Map<AnimalType, Integer> returnMap(AnimalType animalType) {
        Map<AnimalType, Integer> map = switch (animalType) {
            case WOLF -> wolfMap;
            case BOA -> boaMap;
            case FOX -> foxMap;
            case BEAR -> bearMap;
            case EAGLE -> eagleMap;
            case HORSE -> horseMap;
            case DEER -> deerMap;
            case RABBIT -> rabbitMap;
            case MOUSE -> mouseMap;
            case GOAT -> goatMap;
            case SHEEP -> sheepMap;
            case PIG -> pigMap;
            case BUFFALO -> buffaloMap;
            case DUCK -> duckMap;
            case CATERPILLAR -> caterpillarMap;
        };
        return map;
    }

    public static Map<PlantType, Integer> returnMapPlant(AnimalType plantType) {
        Map<PlantType, Integer> map = switch (plantType) {
            case WOLF -> wolfMapPlant;
            case BOA -> boaMapPlant;
            case FOX -> foxMapPlant;
            case BEAR -> bearMapPlant;
            case EAGLE -> eagleMapPlant;
            case HORSE -> horseMapPlant;
            case DEER -> deerMapPlant;
            case RABBIT -> rabbitMapPlant;
            case MOUSE -> mouseMapPlant;
            case GOAT -> goatMapPlant;
            case SHEEP -> sheepMapPlant;
            case PIG -> pigMapPlant;
            case BUFFALO -> buffaloMapPlant;
            case DUCK -> duckMapPlant;
            case CATERPILLAR -> caterpillarMapPlant;
        };
        return map;
    }

    // МЕТОД ПОЛУЧЕНИЯ ОБЪЕКТА ЖИВОТНОГО ИЗ ФАБРИКИ ПО ЧИСЛУ - ПО НОМЕРУ ЖИВОТНОГО ИЗ ENUM'а
    public static Animal getObjectAnimal(int numberToGetValue) {
        AnimalType animalType = AnimalType.values()[numberToGetValue];
        Animal animal = new SimpleAnimalFactory().returnAnimal(animalType);
        return animal;
    }

    // МЕТОД ПОЛУЧЕНИЯ ОБЪЕКТА РАСТЕНИЯ ИЗ ФАБРИКИ ПО ЧИСЛУ - АНАЛОГИЧНО МЕТОДУ ВЫШЕ
    public static Plant getObjectPlant(int numberToGetValue) {
        PlantType plantType = PlantType.values()[numberToGetValue];
        Plant plant = new SimplePlantFactory().returnPlant(plantType);
        return plant;
    }

    // МЕТОД ВЫВОДА НАЧАЛЬНОГО КОЛ-ВА СУЩНОСТЕЙ И РЕЗУЛЬТАТА ЖИЗНЕННОГО ЦИКЛА
    public static void numberOfCreatures(AnimalType[] arrayAnimalType, PlantType[] arrayPlantType, List<Animal>[] arrayListsAnimal, List<Plant>[] arrayListsPlant) {
        for (int i = 0; i < arrayAnimalType.length; i++) {                                              // ЖИВОТНЫЕ
            System.out.print(arrayAnimalType[i].getIconE() + ": " + arrayListsAnimal[i].size() + ". ");
        }
        for (int i = 0; i < arrayPlantType.length; i++) {                                               // РАСТЕНИЯ
            System.out.print(arrayPlantType[i].getIconE() + ": " + arrayListsPlant[i].size() + ". ");
        }
    }

}
