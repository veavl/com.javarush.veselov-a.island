package local;

import creature.animal.Animal;
import creature.plant.Plant;
import util.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import static util.Settings.*;

public class Island {
    public static Location[][] locations;

    public Island(int height, int weight) {                         // Созданы локации
        locations = new Location[height][weight];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public Location getLocations(int height, int weight) {
        return locations[height][weight];                           // Возвращаем конкретную локацию
    }

    public static void populateIsland(Island island) throws InterruptedException {

        // ЗАПОЛНЯЕМ ЛОКАЦИИ
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location location = locations[x][y];

                // МАССИВ для хранения списков Животных
                List<Animal>[] arrayListsAnimal = location.getArrayListsAnimal();
                for (int i = 0; i < arrayListsAnimal.length; i++) {
                    arrayListsAnimal[i] = new CopyOnWriteArrayList<>();                         // ИНИЦИАЛИЗАЦИИ СПИСКА
                    for (int j = 0; j < (arrayAnimalType[i].getMaxQuantityE() / 2); j++) {      // Отталкиваемся от getMaxQuantityE() из ENUM'а, например для WOLF = 30/2
                        arrayListsAnimal[i].add(Settings.getObjectAnimal(i));                   // В каждый СПИСОК List<Animal> add количество объектов ТЕКУЩЕГО ЖИВОТНОГО - 30/2
                    }
                }

                // МАССИВ для хранения списков Растений
                List<Plant>[] arrayListsPlant = location.getArrayListPlant();
                for (int i = 0; i < arrayListsPlant.length; i++) {
                    arrayListsPlant[i] = new CopyOnWriteArrayList<>();
                    for (int j = 0; j < arrayPlantType[i].getMaxQuantityE(); j++) {
                        arrayListsPlant[i].add(Settings.getObjectPlant(i));
                    }
                }
            }
        }
    }

    // Запускаем жизненный ЦИКЛ
    public synchronized static void runLife(Island island) throws InterruptedException {

        // РАБОТАЕМ С КАЖДОЙ ЛОКАЦИЕЙ
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location location = locations[x][y];

                // ПОЛУЧАЕМ СПИСКИ ДЛЯ ЛОКАЦИИ
                List<Animal>[] arrayListsAnimal = location.getArrayListsAnimal();
                List<Plant>[] arrayListsPlant = location.getArrayListPlant();
                // КООРДИНАТЫ ТЕКУЩЕЙ ЛОКАЦИИ
                int X = x;
                int Y = y;
                // РАБОТАЕМ С КАЖДЫМ ЖИВОТНЫМ
                for (List<Animal> list : arrayListsAnimal) {
                    for (Animal animal : list) {

                        AnimalType animalTypeEat = Settings.getType(animal);
                        animal.move(island, X, Y);                           // ПЕРЕМЕЩЕНИЕ животного

                        // РЕАЛИЗАЦИЯ И УДАЛЕНИЯ ХУДЕЮЩИХ
                        int constantNumber = Settings.getConstantNumber(animalTypeEat);     // Получаем номер КОНСТАНТЫ текущего животного
                        animal.decreaseWeight();
                        animal.die(constantNumber, arrayListsAnimal);

                        // 1. СНАЧАЛА КАЖДОЕ ЖИВОТНОЕ animal ПЫТАЕТСЯ КОГО-ТО СЪЕСТЬ --> НУЖЕН ЕЩЕ ОДИН ОБЪЕКТ Animal
                        int numberEating = new Random().nextInt(arrayAnimalType.length + arrayPlantType.length);
                        try {
                            if (numberEating >= arrayAnimalType.length) {
                                numberEating = numberEating - arrayAnimalType.length;
                                PlantType plantType = arrayPlantType[numberEating];
                                Integer integerProbabilityEating = Settings.returnMapPlant(animalTypeEat).get(plantType);
                                animal.eatPlant(numberEating, integerProbabilityEating, arrayListsPlant);
                            } else {
                                AnimalType animalTypeEating = arrayAnimalType[numberEating];
                                Integer integerProbabilityEating = Settings.returnMap(animalTypeEat).get(animalTypeEating);
                                animal.eatAnimal(numberEating, integerProbabilityEating, arrayListsAnimal);
                            }
                        } catch (IndexOutOfBoundsException e) {
                            // System.out.println(e.getMessage()); // Число объектов в списке равно 0
                        }
                    }
                }


                // 2. РАЗМНОЖЕНИЕ - МИНУС В ВЕСЕ
                for (List<Animal> list : arrayListsAnimal) {
                    for (Animal animal : list) {
                        animal.decreaseWeight();    // ТЕРЯЕМ ВЕС!!!
                        int numberPair = new Random().nextInt(arrayAnimalType.length);
                        AnimalType animalType = Settings.getType(animal);
                        if (animalType == arrayAnimalType[numberPair]) {                      // Если есть ПАРА
                            list.add(new SimpleAnimalFactory().returnAnimal(animalType));     // В ТЕКУЩИЙ СПИСОК ДОБАВЛЯЕТСЯ НОВЫЙ ТАКОЙ ОБЪЕКТ
                        }
                    }
                }
                // ПОСЛЕ ЭТОГО РОСТ РАСТЕНИЙ
                for (int i = 0; i < arrayListsPlant.length; i++) {
                    if (arrayListsPlant[i].size() < arrayPlantType[i].getMaxQuantityE() / 2) {         // Если размер списка меньше числа растений из ENUM'a/2 (50)
                        while (arrayListsPlant[i].size() < arrayPlantType[i].getMaxQuantityE()) {      // Пока размер списка меньше 100
                            arrayListsPlant[i].add(Settings.getObjectPlant(i));                        // Заполняем его полностью
                        }
                    }
                }
            }
        } // РАБОТА С КАЖДОЙ ЛОКАЦИЕЙ ОКОНЧЕНА
    } // END runLife

    // ОТОБРАЖЕНИЯ ОБЩЕГО ЧИСЛА ЖИВОТНЫХ И РАСТЕЕНИЙ НА ОСТРОВЕ
    public synchronized boolean display() {

        List<AnimalType> animalTypeList = new ArrayList<>();                // ArrayList ДЛЯ ВСЕХ объектов ЖИВОТНЫХ для всех ЛОКАЦИЙ
        List<PlantType> plantTypeList = new ArrayList<>();

        for (int x = 0; x < locations.length; x++) {                        // Перебираем локации
            for (int y = 0; y < locations[x].length; y++) {
                Location location = locations[x][y];

                // ДЛЯ КАЖДОЙ ЛОКАЦИИ ПОЛУЧАЕМ СПИСКИ ДЛЯ ЛОКАЦИИ
                List<Animal>[] arrayListsAnimal = location.getArrayListsAnimal();
                List<Plant>[] arrayListsPlant = location.getArrayListPlant();

                for (List<Animal> animalList : arrayListsAnimal) {           // КАЖДЫЙ ОБЪЕКТ МАССИВА СПИСКОВ ТЕКУЩЕЙ ЛОКАЦИИ
                    for (Animal animal : animalList) {
                        animalTypeList.add(Settings.getType(animal));                          // ДОБАВЛЯЕТСЯ В animalTypeList
                    }
                }
                for (List<Plant> plantList : arrayListsPlant) {
                    for (Plant plant : plantList) {
                        plantTypeList.add(Settings.getPlantType(plant));
                    }
                }
            }
        }

        for (AnimalType animalType : arrayAnimalType) {
            System.out.print(animalType.getIconE() + ": ");                                 // ПОЛУЧАЕМ ИКОНКУ ИЗ ENUM
            System.out.print(Collections.frequency(animalTypeList, animalType) + ". ");     // ЕЩЕМ В animalTypeList ВСЕ СОВПАДЕНИЯ С ТЕКУЩИМ animalType (ENUM)
        }

        for (PlantType plantType : arrayPlantType) {                                        // ТОЖЕ ДЛЯ РАСТЕНИЙ
            System.out.print(plantType.getIconE() + ": ");
            System.out.print(Collections.frequency(plantTypeList, plantType) + ". ");
        }
        System.out.println();
        System.out.println();

        if (animalTypeList.size() == 0)
            return false;
        return true;
    }
}
