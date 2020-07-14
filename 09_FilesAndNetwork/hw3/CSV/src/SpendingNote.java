public class SpendingNote {
    private static double count;

    private String spendingCase;
    private double money;

    public SpendingNote(String spendingCase, double money) {
        this.spendingCase = spendingCase;
        this.money = money;
    }

    public String getSpendingCase() {
        return spendingCase;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return spendingCase + " " + money;
    }
}
