package creature.animal.herbivore;

import creature.animal.Animal;

public class Deer extends Animal implements Herbivore {

    public double currentWeight = 300.0;

    public Deer () {
        super(300.0, 20, 4, "\uD83E\uDD8C");
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