package creature.animal.herbivore;

import creature.animal.Animal;

public class Horse extends Animal implements Herbivore {

    public double currentWeight = 400.0;

    public Horse () {
        super(400.0, 20, 4, "\uD83D\uDC34");
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