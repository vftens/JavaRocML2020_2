package personalfinance.CSV;

public class ProfitingNote {

    private static double count;

    private String spendingCase;
    private double money;


    public ProfitingNote(String spendSource, double money) {
        this.spendingCase = spendSource;
        this.money = money;
    }

    public String getSpendingCase() {
        return spendingCase;
    }

    public double getMoney() {
        return money;
    }

}