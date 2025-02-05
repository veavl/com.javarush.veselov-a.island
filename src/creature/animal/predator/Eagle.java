package creature.animal.predator;

import creature.animal.Animal;

public class Eagle extends Animal implements Predator {

      public double currentWeight = 6.0;

    public Eagle () {
        super(6.0, 20, 2, "\uD83E\uDD85");
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
