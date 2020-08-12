package com.fesva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
            while (resultSet2.next()){
                String nameString2 = resultSet2.getString("Course name");
                String subscriptionDate = resultSet2.getString("Subscr date");
                System.out.printf("%s \t %s\n", nameString2, subscriptionDate);
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            ex.printStackTrace();
        }
    }
}
