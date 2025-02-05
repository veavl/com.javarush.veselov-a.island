package creature.animal.predator;

import creature.animal.Animal;

public class Fox extends Animal implements Predator {

    public double currentWeight = 8.0;

    public Fox () {
        super(8.0, 30, 2, "\uD83E\uDD8A");
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