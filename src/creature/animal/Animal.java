package creature.animal;

import creature.Creature;
import creature.plant.Plant;
import local.Island;
import local.Location;
import util.AnimalType;
import util.Settings;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Creature {

    public String icon;
    public double maxWeight;
    public int maxCountInCell;
    public int maxSpeed;
    public double currentWeight;
    public AnimalType type;

    public Animal(double maxWeight, int maxCountInCell, int maxSpeed, String icon) {
        this.maxWeight = maxWeight;
        this.maxCountInCell = maxCountInCell;
        this.maxSpeed = maxSpeed;
        this.icon = icon;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public AnimalType getType() {
        return type;
    }

    public double decreaseWeight() {
        return 0;
    }

    // МЕТОД ПЕРЕМЕЩЕНИЯ
    public void move (Island island, int x, int y) {
        if (this.getClass().getName().equals("creature.animal.herbivore.Caterpillar"))  // ГУСЕНИЦЫ НЕ ХОДЯТ
            return;

        Location currentLocation = island.getLocations(x, y);
        // ЛОКАЦИЯ НАЗНАЧЕНИЯ - ПОКА NULL
        Location intendedLocation = null;
        // ОПРЕДЕЛЯЕМ ПОЙДЕТ ЛИ ЖИВОТНОЕ В НОВУЮ ЛОКАЦИЮ -- 50/50
        int probabilityMove = ThreadLocalRandom.current().nextInt(0,2);         // 0 --> не ходим. 1 --> ходим
        // ЕСЛИ ЖИВОТНОЕ ИДЕТ -- ОПРЕДЕЛЯЕМ НОВЫЕ КООРДИНАТЫ
        if (probabilityMove == 1) {
            //System.out.println("+++++ Я пошел НАВЕРХ: ");
            int direction = ThreadLocalRandom.current().nextInt(1,5);
            switch (direction) {
                case 1 -> {                 // ВВЕРХ
                    if (x > 0) {
                        x = x - 1;
                    } else
                        x = Island.locations.length - 1;
                }
            }
            switch (direction) {
                case 2 -> {                 // НАПРАВО
                    if (y < Island.locations[x].length - 1) {
                        y = y + 1;
                    } else
                        y = 0;
                }
            }
            switch (direction) {            // ВНИЗ
                case 3 -> {
                    if (x < Island.locations.length - 1) {
                        x = x + 1;
                    } else
                        x = 0;
                }
            }
            switch (direction) {            // НАЛЕВО
                case 4 -> {
                    if (y > 0) {
                        y = y - 1;
                    } else
                        y = Island.locations[x].length - 1;
                }
            }

            // РАБОТАЕМ С ЛОКАЦИЕЙ НАЗНАЧЕНИЯ - КУДА ПОЙДЕТ ЖИВОТНОЕ
            // ЛОКАЦИЯ НАЗНАЧЕНИЯ УЖЕ ИЗВЕСТНА
            intendedLocation = island.getLocations(x, y);
            // ПОЛУЧАЕМ ИЗ ЛОКАЦИИ НАЗНАЧЕНИЯ МАССИВ СПИСКОВ
            List<Animal>[] arrayListsAnimal = intendedLocation.getArrayListsAnimal();
            // ПОЛУЧАЕМ ИЗ ЛОКАЦИИ НАЗНАЧЕНИЯ СООТВЕТСТВУЮЩИЙ СПИСОК ДЛЯ ТЕКУЩЕГО ЖИВОТНОГО
            List<Animal> animalList = arrayListsAnimal[Settings.getConstantNumber(Settings.getType(this))];
            // ДОБАВЛЯЕМ В СПИСОК ЖИВОТНОЕ
            if (animalList.add(this)) {       // TRUE
                // ТЕПЕРЬ ИЗ ТЕКУЩЕЙ ЛОКАЦИИ НУЖНО УДАЛИТЬ ТЕКУЩЕЕ ЖИВОТНОЕ
                // ПОЛУЧАЕМ ИЗ ТЕКУЩЕЙ ЛОКАЦИИ МАССИВ СПИСКОВ
                List<Animal>[] arrayListsAnimalCurrent = currentLocation.getArrayListsAnimal();
                // ПОЛУЧАЕМ ИЗ ТЕКУЩЕЙ ЛОКАЦИИ СООТВЕТСТВУЮЩИЙ СПИСОК ДЛЯ ТЕКУЩЕГО ЖИВОТНОГО
                List<Animal> animalListCurrent = arrayListsAnimalCurrent[Settings.getConstantNumber(Settings.getType(this))];
                animalListCurrent.remove(this);
            }
        }
        else {
            //System.out.println("----- Я остаюсь!");
        }

    }

    // СЪЕСТЬ КОГО-ТО
    public boolean eatAnimal(int numberEating, Integer integerProbabilityEating, List<Animal>[] arrayListsAnimal) {
        if (arrayListsAnimal[numberEating].size() == 0) {        // ЕСЛИ НЕТ ТРАВЫ ИЛИ КУСТОВ
            return false;
        }
        int randomNumber = new Random().nextInt(100) + 1;
        if (integerProbabilityEating != null && integerProbabilityEating != 0) {
            if ((integerProbabilityEating > 100 - randomNumber)) {                // ВЕРОЯТНОСТЬ ПОЕДАНИЯ - ОК
                this.setCurrentWeight(this.getCurrentWeight() + arrayListsAnimal[numberEating].get(0).getMaxWeight());  // К текущему весу прибавляется
                if (this.getCurrentWeight() > this.getMaxWeight()) {
                    this.setCurrentWeight(this.getMaxWeight());
                }
                arrayListsAnimal[numberEating].remove(0);                       // УДАЛЯЕТСЯ ОБЪЕКТ
                return true;
            }
        }
        return false;
    }

    // ЗДЕСЬ ЕДЯТ ТОЛЬКО РАСТЕНИЯ И НЕТ ВЕРОЯТНОСТИ ПОЕДАНИЯ. НО КАК И В МЕТОДЕ ВЫШЕ - ЕСТЬ ДОБАВЛЕНИЕ ВЕСА СЪЕДЕННОГО (РАСТЕНИЯ) К ВЕСУ ТОГО КТО ЕСТ.
    public boolean eatPlant(int numberEating, Integer integerProbabilityEating, List<Plant>[] arrayListsPlant) {
        if (arrayListsPlant[numberEating].size() == 0) {        // ЕСЛИ НЕТ ТРАВЫ ИЛИ КУСТОВ
            return false;
        }
        else if (integerProbabilityEating != null && integerProbabilityEating != 0) {    // ЕСЛИ МЫШЬ -- ТО ОК. ЕСЛИ ВОЛК (НЕ ЕСТЬ ТРАВУ) -- ТО ПРОПУСКАЕМ ЭТОТ БЛОК
            this.setCurrentWeight(this.getCurrentWeight() + arrayListsPlant[numberEating].get(0).getWeight());
            if (this.getCurrentWeight() > this.getMaxWeight()) {
                this.setCurrentWeight(this.getMaxWeight());
            }
            arrayListsPlant[numberEating].remove(0);    // УДАЛЯЕМ СЪЕДЕННЫЙ ПУЧОК ТРАВЫ, ПОСЛЕ ТОГО, КАК ВЫШЕ ДОБАВИЛИ ЕГО ВЕС К ТОМУ КТО ЕСТ
        }
        return true;
    }

    // Передаем номер константы из ENUM'а и МАССИВ СПИСКОВ: по № КОНСТАНТЫ УЗНАЕМ НУЖНЫЙ СПИСОК - В КОТОРОМ НАХОДИТСЯ ТЕКУЩИЙ ОБЪЕКТ
    public void die(int constantNumber, List<Animal>[] arrayListsAnimal) {
        if (this.getMaxWeight() - this.getCurrentWeight() > this.getMaxWeight() / 2) {      // ЕСЛИ ТЕКУЩИЙ ВЕС МЕНЬШЕ 50% ОТ МАКСИМАЛЬНОГО
            for (int i = 0; i < arrayListsAnimal[constantNumber].size(); i++) {             // ПЕРЕБИРАЕМ ВСЕ ЭЛЕМЕНТЫ СПИСКА
                if(this.hashCode() == arrayListsAnimal[constantNumber].get(i).hashCode())   // И СРАВНИВАЕМ ИХ ХЭШКОДЫ С ХЭШКОДОМ ТЕКУЩЕГО ЭЛЕМЕНТА
                    arrayListsAnimal[constantNumber].remove(i);                             // УДАЛЯЕМ ТЕКУЩИЙ ЭЛЕМЕНТ/ОБЪЕКТ
            }
        }
    }
}
