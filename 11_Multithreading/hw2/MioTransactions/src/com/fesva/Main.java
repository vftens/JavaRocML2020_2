package com.fesva;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Random;
import fesva.com.Banko;

public class Main {

    public static void main(String[] args) {

//        HashMap<String, Accounti> accounts = generateAccounts();
        Banko bank = new fesva.com.Banko();

        HashMap<String, fesva.com.Accounti> accounts = new HashMap<>();
        fesva.com.Accounti acc1 = new fesva.com.Accounti("111", 500000);
        fesva.com.Accounti acc2 = new fesva.com.Accounti("222", 500000);
        fesva.com.Accounti acc3 = new fesva.com.Accounti("333", 1000000);
        fesva.com.Accounti acc4 = new fesva.com.Accounti("444", 0);

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
        System.out.println("111: " + bank.getBalance("111") + " статус: " + !acc1.isBlock());
        System.out.println("222: " + bank.getBalance("222") + " статус: " + !acc2.isBlock());
        System.out.println("333: " + bank.getBalance("333") + " статус: " + !acc3.isBlock());
        System.out.println("444: " + bank.getBalance("444") + " статус: " + !acc4.isBlock());
    }

    private static void doTransactionRun(fesva.com.Accounti account) {

    }
}
