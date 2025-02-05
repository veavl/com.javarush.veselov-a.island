package creature.animal.herbivore;

import creature.animal.Animal;

public class Buffalo extends Animal implements Herbivore {

    public double currentWeight = 700.0;

    public Buffalo () {
        super(700.0, 10, 3, "\uD83D\uDC2E");
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