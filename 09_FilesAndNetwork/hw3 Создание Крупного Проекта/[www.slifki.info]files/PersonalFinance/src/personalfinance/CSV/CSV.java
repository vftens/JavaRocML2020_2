package personalfinance.CSV;

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
    private static final boolean Debug = false;
    private static final Pattern SPENDING_PATTERN =
            Pattern.compile("([/|\\\\]\\s?\\w+\\s?\\w+?\\s?>?\\w+\\s{4})");

    public static List<SpendingNote> spendsList = new ArrayList<>();
    public static List<ProfitingNote> profitsList = new ArrayList<>();
    public static List<Transactioning> transactionings = new ArrayList<>();

    public static void mymain() throws Exception {
        //Build reader instance
        List<String[]> allRows;
        String line = "";

        try (FileReader fileReader = new FileReader(FILE);
             CSVReader reader = new CSVReader(fileReader, ',', '"', 1)) {
            //Read all rows at once
            allRows = reader.readAll();

            fileReader.close();  // FileReader тоже надо закрывать:
            //Read CSV line by line and use the string array as you want
            for (String[] row : allRows) {

                if (Debug) for (String r : row) {
                    System.out.println(r);
                }
                line = Arrays.toString(row);
                if (Debug) System.out.println(line);

                Matcher spendMatch = SPENDING_PATTERN.matcher(line);
                if (spendMatch.find()) {
                    String spendType = row[4];
                    if (Debug) System.out.println("spendType = " + spendType);
                    if (Debug) System.out.println(spendMatch.groupCount());
                    SpendingNote spendingNote = new SpendingNote(spendType,
                            Double.parseDouble(row[7].replaceAll(",", ".")));
                    ProfitingNote profitingNote = new ProfitingNote(spendType,
                            Double.parseDouble(row[6].replaceAll(",", ".")));
                    spendsList.add(spendingNote);
                    profitsList.add(profitingNote);
                    Transactioning transactioning = new Transactioning(spendType,
                            Double.parseDouble(row[6].replaceAll(",", ".")),
                            Double.parseDouble(row[7].replaceAll(",", ".")));
                    transactionings.add(transactioning);
                }
            }
        }

        double totalSpend = spendsList.stream().mapToDouble(SpendingNote::getMoney).sum();
        double totalProfit = profitsList.stream().mapToDouble(ProfitingNote::getMoney).sum();

        System.out.printf("\nСумма расходов: %.2f руб. \n", totalSpend);
        System.out.printf("Сумма доходов: %.2f руб. \n\n", totalProfit);

        System.out.println("Суммы расходов по организациям:");
        for (SpendingNote s : spendsList) {
            double sum = s.getMoney();
            if (sum > 0) {
                System.out.printf("%s %.2f руб. \n", s.getSpendingCase(), sum);
            }
        }
    }

    private static class Summa {
        double income;
        double withdraw;

        Summa(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        // сложение сумм
        static Summa merge(Summa s1, Summa s2) {
            return new Summa(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }

        // mapper - конвертация из Transactioning
        static Summa fromTransaction(Transactioning t) {
            return new Summa(t.getIncome(), t.getWith_draw());
        }
    }
}
