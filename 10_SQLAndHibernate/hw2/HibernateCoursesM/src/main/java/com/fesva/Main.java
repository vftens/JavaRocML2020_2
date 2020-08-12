package com.fesva;
//requires net.bytebuddy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // write your code here
        StandardServiceRegistry registry = new
                StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        CourseMy course = session.get(CourseMy.class, 1);
        System.out.println(course.getName());
        System.out.println(course.getStudentsCount() );


        
        /*
        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";
        //  :3306/skillbox
        String user = "root";
        String password = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
            while (resultSet.next()) {
                CourseMy courseMy = new CourseMy();
                //courseMy.setId();
                String courseName = resultSet.getString("Course name");
                System.out.println(courseName);

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


         */
        sessionFactory.close();
    }

}

/*
 код, который выводит имя и количество студентов любого курса.
 */
