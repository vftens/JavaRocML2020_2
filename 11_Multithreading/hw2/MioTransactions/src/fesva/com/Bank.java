package fesva.com;

//import jdk.internal.net.http.common.Pair;

import java.util.HashMap;

import static jdk.nashorn.internal.objects.NativeArray.sort;

public class Bank extends Banko {
    private static int currentStack = 0;
    static Queue queue;

    private HashMap<String, Account> accounts;

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Bank(Object accounts) {
        Object lock = new Object();
    }

    @Override
    public Object getAccounts() {
        return super.getAccounts();
    }

    @Override
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        return super.isFraud(fromAccountNum, toAccountNum, amount);
    }

    private synchronized void inPair(String fromAccountNum, String toAccountNum) {
        //Pair<String, String> elem = Pair.pair(fromAccountNum, toAccountNum);
        try {
            while (!queue.offer(Pair.pair(fromAccountNum, toAccountNum))) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentStack++;

        notify();
    }

    private synchronized Pair outPair1() {
        while (currentStack == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Pair el1 = (Pair) queue.peek(); // элемент не удаляется
        currentStack--;

        notify();
        return el1;
    }

    private synchronized Pair outPair2() {
        while (currentStack == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Pair el2 = (Pair) queue.poll();
        currentStack--;
        notify();

        return el2;
    }

    @Override
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        //sort(queue(in));
        //synchronized {
        inPair(fromAccountNum, toAccountNum);
        Pair el1 = outPair1();

        Pair el2 = outPair2();

        sort(el1, el2);
        fromAccountNum = (String) el1.first;
        toAccountNum = (String) el1.second;

        currentStack++;
        super.transfer(fromAccountNum, toAccountNum, amount);
        notify();
    }

    @Override
    public long getBalance(String accountNum) {
        return super.getBalance(accountNum);
    }

    @Override
    protected void setAccounts() {
        super.setAccounts();
    }

}