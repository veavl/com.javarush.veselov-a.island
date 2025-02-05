package creature.animal.herbivore;

import creature.animal.Animal;

public class Mouse extends Animal implements Herbivore {

    public double currentWeight = 0.05;

    public Mouse () {
        super(0.05, 300, 1, "\uD83D\uDC2D");
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return Math.ceil(currentWeight * 10000) / 10000;
    }

    @Override               // У МЫШИ СВОЯ РЕАЛИЗАЦИЯ ОКРУГЛЕНИЯ, ТАК КАК МАЛЕНЬКИЙ ВЕС
    public double decreaseWeight() {
        this.currentWeight = this.currentWeight - this.maxWeight/20;
        return Math.ceil(currentWeight * 10000) / 10000;
    }

}