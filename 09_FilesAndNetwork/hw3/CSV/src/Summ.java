public class Summ {
    //class Summary {
        double income;
        double withdraw;

        Summ(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        // сложение сумм
        static CSV.Summ merge(CSV.Summ s1, CSV.Summ s2) {
            return new CSV.Summ(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }

        // mapper - конвертация из Transaction
        static CSV.Summ fromTransaction(Transaction t) {
            return new CSV.Summ(t.getIncome(), t.getWithdraw());
        }
    }
}
