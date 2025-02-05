package util;

public enum AnimalType {

    WOLF("Волк", 30, 50, "\uD83D\uDC3A"),        // nameE, maxQuantityE, maxWeightE, Icon
    BOA("Удав", 30, 15, "\uD83D\uDC0D"),
    FOX("Лиса", 30, 8, "\uD83E\uDD8A"),
    BEAR("Медведь", 5, 500, "\uD83D\uDC3B"),
    EAGLE("Орел", 20, 6, "\uD83E\uDD85"),
    HORSE("Лошадь", 20, 400, "\uD83D\uDC34"),
    DEER("Олень", 20, 300, "\uD83E\uDD8C"),
    RABBIT("Кролик", 150, 2, "\uD83D\uDC30"),
    MOUSE("Мышь", 300, 0.05, "\uD83D\uDC2D"),
    GOAT("Коза", 140, 60, "\uD83D\uDC10"),
    SHEEP("Овца", 140, 70, "\uD83D\uDC11"),
    PIG("Кабан", 50, 400, "\uD83D\uDC37"),
    BUFFALO("Буйвол", 10, 700, "\uD83D\uDC2E"),
    DUCK("Утка", 200, 1, "\uD83E\uDD86"),
    CATERPILLAR("Гусеница", 1000, 0.01, "\uD83D\uDC1B");

    private String nameE;
    private int maxQuantityE;
    private double maxWeightE;
    private String iconE;

    AnimalType(String nameE, int maxQuantityE, double maxWeightE, String iconE) {
        this.nameE = nameE;
        this.maxQuantityE = maxQuantityE;
        this.maxWeightE = maxWeightE;
        this.iconE = iconE;
    }

    public String getName() {
        return nameE;
    }

    public int getMaxQuantityE() {
        return maxQuantityE;
    }

    public double getMaxWeightE() {
        return maxWeightE;
    }

    public String getIconE() {
        return iconE;
    }
}
