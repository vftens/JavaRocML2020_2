package com.fesva;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Main {
    public static final boolean DEBUG = false;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";

        String user = "root";
        String password = "testtest";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String mySQLstr = "SELECT c.name AS 'Course name'," +
                    "COUNT(sub.subscription_date)/8 AS 'AVG buy course per month'  " +
                    "FROM Courses c " +
                    "JOIN Subscriptions sub ON c.id=sub.course_id " +
                    "GROUP BY c.name  " +
                    "ORDER BY c.name";

            String mySQLstr2 =
                    "SELECT c.name AS 'Course name', sub.subscription_date AS 'Subscr date', " +
                            "COUNT(sub.subscription_date) AS 'AVG buy course per month'  " +
                            "FROM Courses c " +
                            "JOIN Subscriptions sub ON c.id=sub.course_id " +
                            "GROUP BY c.name  " +
                            "ORDER BY c.name";

            ResultSet resultSet =
                    statement.executeQuery(mySQLstr);

            if (DEBUG) {
                System.out.println("Название курса\t\tСреднее количество покупок в месяц");
            }

            while (resultSet.next()) {
                String nameString = resultSet.getString("Course name");
                String monthSubString = resultSet.getString("AVG buy course per month");

                if (DEBUG) {
                    System.out.printf("%s \t\t\t-\t %s\n", nameString, monthSubString);
                }
            }

            System.out.println();
            ResultSet resultSet2 =
                    statement.executeQuery(mySQLstr2);
            if (DEBUG) {
                System.out.println("Название курса\tДата подписки");
            }

            ArrayList<String> result = new ArrayList<>();
            while (resultSet2.next()) {
                String nameString2 = resultSet2.getString("Course name");
                String subscriptionDate = resultSet2.getString("Subscr date");
                if (DEBUG) {
                    System.out.printf("%s \t %s\n", nameString2, subscriptionDate);
                }

                result.add(nameString2);  // запоминаем название курса
            }

            for (String res : result) {
                String mySQLstr3 = String.format(
                        "SELECT pl.course_name AS 'Course name', pl.subscription_date AS 'Subscr date' " +
                                "FROM PurchaseList pl WHERE pl.course_name = \"%s\" ORDER BY pl.subscription_date",
                        res);

                ResultSet resultSet3 =
                        statement.executeQuery(mySQLstr3);
                int resultCount = 0;
                String firstDate = "", lastDate = "";
                boolean firstFlag = true;
                while (resultSet3.next()) {
                    String nameString3 = resultSet3.getString("Course name");
                    String subscriptionDate = resultSet3.getString("Subscr date");
                    if (DEBUG) System.out.printf("%s \t %s \n", nameString3, subscriptionDate);
                    resultCount++;
                    if (firstFlag) {
                        firstDate = subscriptionDate;
                        firstFlag = false;
                    } else {
                        lastDate = subscriptionDate;
                    }
                }
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(lastDate);

                c1.setTime(date1);
                c2.setTime(date2);
                int monthDiff = c2.get(Calendar.MONTH) - c1.get((Calendar.MONTH)) + 1;
                System.out.printf("%s Number of Purchases per Month: %1.3f \n", res,
                        ((float) resultCount) / (float) monthDiff);
            }

            System.out.println("");

            for (String res : result) {
                String mySQLstr4 = String.format(
                        "SELECT pl.course_name," +
                                " COUNT(MONTH(pl.subscription_date)) AS 'avgM'," +
                                "TIMESTAMPDIFF(MONTH,MIN(pl.subscription_date)," +
                                "MAX(pl.subscription_date) ) " +
                                " AS 'avgMonth'," +
                                " pl.course_name AS 'Course name', " +
                                "pl.subscription_date AS 'Subscr date' " +
                                " FROM PurchaseList pl " +
                                " WHERE pl.course_name = \"%s\" GROUP BY pl.course_name", res);
                ResultSet resultSet4 =
                        statement.executeQuery(mySQLstr4);
                while (resultSet4.next()) {
                    String nameString4 = resultSet4.getString("Course name");
                    String subscriptionDate = resultSet4.getString("Subscr date");
                    String avgMon = resultSet4.getString("avgM");
                    int resultCount = Integer.parseInt(avgMon);
                    String avgMonth = resultSet4.getString("avgMonth");
                    int monthDiff = Integer.parseInt(avgMonth) + 1;
                    System.out.printf("Course %s \t %s \n", nameString4, subscriptionDate);
                    System.out.printf("Results Count %1.0f Months %1.0f for %s Number of Purchases per Month: %1.3f \n",
                            (float) resultCount, (float) monthDiff,
                            res, ((float) resultCount) / (float) monthDiff);
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            ex.printStackTrace();
        }
    }
}



