package creature.animal.herbivore;

import creature.animal.Animal;

public class Sheep extends Animal implements Herbivore {

    public double currentWeight = 70.0;

    public Sheep () {
        super(70.0, 140, 3, "\uD83D\uDC11");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/40;
        return Math.ceil(currentWeight * 10000) / 10000;
    }
}