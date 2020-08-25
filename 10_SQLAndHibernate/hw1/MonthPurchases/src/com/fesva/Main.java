package com.fesva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";
        //  :3306/skillbox
        String user = "root";
        String password = "testtest";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String SQLstr = "SELECT c.name AS 'Course name'," +
                    "COUNT(sub.subscription_date)/12 AS 'AVG buy course per month'  " +
                    "FROM Courses c " +
                    "JOIN Subscriptions sub ON c.id=sub.course_id " +
                    "GROUP BY c.name  " +
                    "ORDER BY c.name";

            // SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl
            // WHERE pl.course_name = "Веб-разработчик c 0 до PRO" ORDER BY pl.subscription_date;

            String SQLstr2 =
                    "SELECT c.name AS 'Course name', sub.subscription_date AS 'Subscr date', " +
                            "COUNT(sub.subscription_date) AS 'AVG buy course per month'  " +
                            "FROM Courses c " +
                            //"WHERE c.course_name = c.name " +
                            "JOIN Subscriptions sub ON c.id=sub.course_id " +
                            "GROUP BY c.name  " +
                            "ORDER BY c.name";

            //*/
            ResultSet resultSet =
                    statement.executeQuery(SQLstr);
            //ResultSet resultSet2 =
            //statement.executeQuery(SQLstr2);
            System.out.println("Название курса\t\tСреднее количество покупок в месяц");

            while (resultSet.next()) {
                String nameString = resultSet.getString("Course name");
                String monthSubString = resultSet.getString("AVG buy course per month");

                System.out.printf("%s \t\t\t-\t %s\n", nameString, monthSubString);
            }

            System.out.println();
            ResultSet resultSet2 =
                    statement.executeQuery(SQLstr2);
            System.out.println("Название курса\tДата подписки");

            List<String> result = null;
            while (resultSet2.next()) {
                String nameString2 = resultSet2.getString("Course name");
                String subscriptionDate = resultSet2.getString("Subscr date");
                System.out.printf("%s \t %s\n", nameString2, subscriptionDate);

                result.add(nameString2);  // запоминаем название курса
            }
            //String res = null;
            for (String res: result) {
                //while (result.get()next()) {
                String SQLstr3 = String.format("SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = \"%s\" ORDER BY pl.subscription_date", res); // .nameString2);
                ResultSet resultSet3 =
                        statement.executeQuery(SQLstr3);
                while (resultSet3.next()) {
                    String nameString3 = resultSet3.getString("");
                    System.out.println(nameString3);
                }
            }

        } catch (Exception ex) {
            ex.getStackTrace();
            ex.printStackTrace();
        }
    }
}
