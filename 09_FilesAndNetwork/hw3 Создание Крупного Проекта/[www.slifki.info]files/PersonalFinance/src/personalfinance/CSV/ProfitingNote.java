package personalfinance.CSV;

public class ProfitingNote {

    private static double count;

    private String spendCase;
    private double money;


    public ProfitingNote(String spendSource, double money) {
        this.spendCase = spendSource;
        this.money = money;
    }

    public String getSpendCase() {
        return spendCase;
    }

    public double getMoney() {
        return money;
    }

}