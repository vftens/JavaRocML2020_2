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

            String SQLstr = "SELECT c.name AS 'Course name'," +
                    "COUNT(sub.subscription_date)/8 AS 'AVG buy course per month'  " +
                    "FROM Courses c " +
                    "JOIN Subscriptions sub ON c.id=sub.course_id " +
                    "GROUP BY c.name  " +
                    "ORDER BY c.name";

            String SQLstr2 =
                    "SELECT c.name AS 'Course name', sub.subscription_date AS 'Subscr date', " +
                            "COUNT(sub.subscription_date) AS 'AVG buy course per month'  " +
                            "FROM Courses c " +
                            "JOIN Subscriptions sub ON c.id=sub.course_id " +
                            "GROUP BY c.name  " +
                            "ORDER BY c.name";

            ResultSet resultSet =
                    statement.executeQuery(SQLstr);

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
                    statement.executeQuery(SQLstr2);
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
                String SQLstr3 = String.format(
                        "SELECT pl.course_name AS 'Course name', pl.subscription_date AS 'Subscr date' " +
                                "FROM PurchaseList pl WHERE pl.course_name = \"%s\" ORDER BY pl.subscription_date",
                        res);

                ResultSet resultSet3 =
                        statement.executeQuery(SQLstr3);
                int resultCount = 0;
                String FirstDate = "", LastDate = "";
                boolean FirstFlag = true;
                while (resultSet3.next()) {
                    String nameString3 = resultSet3.getString("Course name");
                    String subscriptionDate = resultSet3.getString("Subscr date");
                    System.out.printf("%s \t %s \n", nameString3, subscriptionDate);
                    resultCount++;
                    if (FirstFlag) {
                        FirstDate = subscriptionDate;
                        FirstFlag = false;
                    } else {
                        LastDate = subscriptionDate;
                    }
                }
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(FirstDate);
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(LastDate);

                c1.setTime(date1);
                c2.setTime(date2);
                int monthDiff = c2.get(Calendar.MONTH) - c1.get((Calendar.MONTH));
                System.out.printf("Number of Purchases per Month: %1.3f \n", ((float) resultCount) / (float) monthDiff);
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            ex.printStackTrace();
        }
    }
}
