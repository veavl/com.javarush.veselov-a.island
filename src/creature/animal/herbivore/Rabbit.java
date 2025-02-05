package creature.animal.herbivore;

import creature.animal.Animal;

public class Rabbit extends Animal implements Herbivore {

    public double currentWeight = 2.0;

    public Rabbit () {
        super(2.0, 150, 2, "\uD83D\uDC30");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/25;
        return Math.ceil(currentWeight * 10000) / 10000;
    }
}