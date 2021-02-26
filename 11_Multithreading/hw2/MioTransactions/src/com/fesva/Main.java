package com.fesva;

import java.util.ArrayList;
import java.util.HashMap;

import fesva.com.Accounti;
import fesva.com.Bank;

public class Main {

    public static void main(String[] args) {

//
        Bank bank = new fesva.com.Bank();

        HashMap<String, Accounti> accounts = new HashMap<>();
        fesva.com.Account acc1 = new fesva.com.Account("1111", 500000);
        fesva.com.Account acc2 = new fesva.com.Account("2222", 500000);
        fesva.com.Account acc3 = new fesva.com.Account("3333", 1000000);
        fesva.com.Account acc4 = new fesva.com.Account("4444", 0);

        accounts.put(acc1.getAccNumber(), acc1);
        accounts.put(acc2.getAccNumber(), acc2);
        accounts.put(acc3.getAccNumber(), acc3);
        accounts.put(acc4.getAccNumber(), acc4);

        accounts.forEach((k, v) -> System.out.println(k + ": " + v));

        bank.setAccounts(accounts);

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new Thread(() -> {
            for (int i = 0; i < 8; i++) {
                bank.transfer(acc1.getAccNumber(), acc2.getAccNumber(), 10000 + 10000 * i);
            }
        }));
        threads.add(new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                bank.transfer(acc3.getAccNumber(), acc4.getAccNumber(), 5000 * i);
            }
        }));
        threads.add(new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bank.transfer(acc2.getAccNumber(), acc4.getAccNumber(), 1000);
            }
        }));

        threads.forEach(Thread::start);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1111: " + bank.getBalance("1111") + " статус: " + !acc1.isBlock());
        System.out.println("2222: " + bank.getBalance("2222") + " статус: " + !acc2.isBlock());
        System.out.println("3333: " + bank.getBalance("3333") + " статус: " + !acc3.isBlock());
        System.out.println("4444: " + bank.getBalance("4444") + " статус: " + !acc4.isBlock());
    }

    private static void doTransactionRun(fesva.com.Accounti account) {

    }
}