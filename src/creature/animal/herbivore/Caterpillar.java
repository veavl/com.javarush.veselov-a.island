package creature.animal.herbivore;

import creature.animal.Animal;

public class Caterpillar extends Animal implements Herbivore {

    public double currentWeight = 0.01;

    public Caterpillar () {
        super(0.01, 1000, 0, "");
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