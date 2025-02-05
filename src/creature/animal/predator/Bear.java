package creature.animal.predator;

import creature.animal.Animal;

public class Bear extends Animal implements Predator {

      public double currentWeight = 500.0;

    public Bear () {
        super(500.0, 5, 2, "\uD83D\uDC3B");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/30;
        return Math.ceil(currentWeight * 10000) / 10000;
    }

}
