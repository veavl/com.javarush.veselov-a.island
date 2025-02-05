package util;

public enum PlantType {

    GRASS("Трава", 100, 1, "\uD83C\uDF3E"),
    SHRUB("Кусты", 100, 1, "\uD83C\uDF40");

    private String nameE;
    private int maxQuantityE;
    private double maxWeightE;
    private String iconE;

    PlantType (String nameE, int maxQuantityE, double maxWeightE, String iconE) {
        this.nameE = nameE;
        this.maxQuantityE = maxQuantityE;
        this.maxWeightE = maxWeightE;
        this.iconE = iconE;
    }

    public String getName() {
        return nameE;
    }

    public int getMaxQuantityE() {return maxQuantityE;
    }

    public String getIconE() {
        return iconE;
    }
}
