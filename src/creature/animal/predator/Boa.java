package creature.animal.predator;

import creature.animal.Animal;

public class Boa extends Animal implements Predator {

    public double currentWeight = 15.0;

    public Boa () {
        super(15.0, 30, 1, "\uD83D\uDC0D");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/30;
        return Math.ceil(currentWeight * 10000) / 10000;
    }
}