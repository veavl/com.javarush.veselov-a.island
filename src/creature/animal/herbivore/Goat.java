package creature.animal.herbivore;

import creature.animal.Animal;

public class Goat extends Animal implements Herbivore {

    public double currentWeight = 60.0;

    public Goat () {
        super(60.0, 140, 3, "\uD83D\uDC10");
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