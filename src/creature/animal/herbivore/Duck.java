package creature.animal.herbivore;

import creature.animal.Animal;

public class Duck extends Animal implements Herbivore {

    public double currentWeight = 1.0;

    public Duck () {
        super(1.0, 200, 4, "\uD83E\uDD86");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/20;
        return Math.ceil(currentWeight * 10000) / 10000;
    }
}