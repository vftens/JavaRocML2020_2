package personalfinance.CSV;

public class Transactioning {

    private String description;
    private double income;
    private double withdraw;

    public Transactioning(String description, double income, double withdraw) {
        this.description = description;
        this.income = income;
        this.withdraw = withdraw;
    }

    public String getDescription() {
        return description;
    }

    public double getIncome() {
        return income;
    }

    public double getWithdraw() {
        return withdraw;
    }

}
