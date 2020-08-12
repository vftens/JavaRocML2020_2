package com.fesva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        // write your code here
        StandardServiceRegistry registry = new
                StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        int num = 1;
        System.out.print("Введите номер Ид искомого курса:");
        try {
            num = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CourseMy course = session.get(CourseMy.class, num);

        try {
            System.out.println("Курс " + course.getId());
            System.out.println(course.getName());
            System.out.println("Type = " + course.getType());
            System.out.println("Студентов = " + course.getStudentsCount());
            System.out.println(course.getDescription());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Sorry, no such Course.");
        }
        sessionFactory.close();
    }
}

/*
 код, который выводит имя и количество студентов любого курса.
 */
