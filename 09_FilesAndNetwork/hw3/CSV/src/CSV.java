import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import au.com.bytecode.opencsv.CSVReader;

public class CSV {
    @SuppressWarnings("resource")
    private static final String FILE = "movementList.csv";
    private static final boolean Debug = false; //false; //true;

    public static List<SpendNote> spendsList = new ArrayList<>();
    public static List<ProfitNote> profitsList = new ArrayList<>();
    public static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //Build reader instance
        List<String[]> allRows;
        String line = "";
        String cvsSplitBy = ",;";

        try (CSVReader reader = new CSVReader(new FileReader(FILE), ',', '"', 1)) {
            //Read all rows at once
            allRows = reader.readAll();
        }
        //Read CSV line by line and use the string array as you want
        for (String[] row : allRows) {

            if (Debug) for (String r : row) {
                System.out.println(r);
            }
            line = Arrays.toString(row);
            if (Debug) System.out.println(line);
            String[] splitDoc = line.split(cvsSplitBy);
            if (Debug) System.out.println(Arrays.toString(splitDoc));
            //splitDoc.group
            Pattern SPENDING_PATTERN = Pattern.compile("([/|\\\\]\\s?\\w+\\s?\\w+?\\s?>?\\w+\\s{4})");
            Matcher spendMatch = SPENDING_PATTERN.matcher(line); //splitDoc[0]); // 5
            if (spendMatch.find()) {
                String spendType = spendMatch.group(1).substring(1).trim();
                spendType = row[4];
                if (Debug) System.out.println("spendType = " + spendType);
                if (Debug) System.out.println(spendMatch.groupCount());
                SpendNote spendNote = new SpendNote(spendType,
                        Double.parseDouble(row[7].replaceAll(",", ".")));  // 7 // splitDoc
                ProfitNote profitNote = new ProfitNote(spendType,
                        Double.parseDouble(row[6].replaceAll(",", "."))); // splitDoc
                spendsList.add(spendNote);
                profitsList.add(profitNote);
                Transaction transaction = new Transaction(spendType,
                        Double.parseDouble(row[6].replaceAll(",", ".")),
                        Double.parseDouble(row[7].replaceAll(",", ".")));  // splitDoc
                transactions.add(transaction);

                /*if (Debug && spendNote.getMoney() > 0)
                    System.out.printf("%s %.2f\n", spendNote.getSpendCase(),
                            //spendType,
                            spendNote.getMoney());

                 */
            }
        }

        double totalSpend = spendsList.stream().mapToDouble(SpendNote::getMoney).sum();
        double totalProfit = profitsList.stream().mapToDouble(ProfitNote::getMoney).sum();

        if (Debug) transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDescription,
                        Collectors.mapping(Summary::fromTransaction,
                                Collectors.reducing(new Summary(0.0, 0.0), Summary::merge))))
                .forEach((s, summ) -> System.out.println(s + "\t" + summ.income + "\t" + summ.withdraw));
        System.out.printf("Сумма расходов: %.2f руб. \n", totalSpend);
        System.out.printf("Сумма доходов: %.2f руб. \n\n", totalProfit);

        System.out.println("Суммы расходов по организациям:");
        for (SpendNote s : spendsList) {
            if (s.getMoney() > 0) {
                System.out.printf("%s %.2f руб. \n", s.getSpendCase(), s.getMoney());
            }
        }
    }

    private static class Summary {
        double income;
        double withdraw;

        Summary(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        // сложение сумм
        static Summary merge(Summary s1, Summary s2) {
            return new Summary(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }

        // mapper - конвертация из Transaction
        static Summary fromTransaction(Transaction t) {
            return new Summary(t.getIncome(), t.getWithdraw());
        }
    }
}
