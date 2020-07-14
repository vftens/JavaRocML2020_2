public class Transactioning {

    private String description;
    private double income;
    private double with_draw;

    public Transactioning(String description, double income, double with_draw) {
        this.description = description;
        this.income = income;
        this.with_draw = with_draw;
    }

    public String getDescription() {
        return description;
    }

    public double getIncome() {
        return income;
    }

    public double getWith_draw() {
        return with_draw;
    }

}
