package creature.animal.predator;

import creature.animal.Animal;

public class Wolf extends Animal implements Predator {

      public double currentWeight = 50.0;

    public Wolf () {
        super(50.0, 30, 3, "\uD83D\uDC3A");
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
