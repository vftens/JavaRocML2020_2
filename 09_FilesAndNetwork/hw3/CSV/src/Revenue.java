public class Revenue {

    private double income;
    private double expenditure;
    private String vendor;

    public void LineOfStatement(String income, String expenditure, String vendor) {
        this.income = Double.parseDouble(income);
        this.expenditure = Double.parseDouble(expenditure);
        String[] v = vendor.replaceAll("([/\\\\])", " ").split("\\s{4,}");
        this.vendor = v[1].substring(v[1].indexOf(' '));
    }
}
