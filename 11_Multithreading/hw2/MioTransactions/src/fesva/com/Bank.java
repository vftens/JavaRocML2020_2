package fesva.com;

//import jdk.internal.net.http.common.Pair;

import java.util.HashMap;

//import static jdk.nashorn.internal.objects.NativeArray.sort;

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

    private synchronized void inPair(String fromAccountNum, String toAccountNum) throws NullPointerException {

        Pair<String, String> elem = Pair.pair(fromAccountNum, toAccountNum);
        try {
            while (!queue.offer(elem)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("36 currentStack=" + currentStack);
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

    private synchronized Pair outPair1() throws NullPointerException {
        while (currentStack == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("currentStack==" + currentStack);
                e.printStackTrace();
            }
        }
        Pair el1 = null;
        try {
            el1 = (Pair) queue.peek(); // элемент не удаляется
        } catch (Exception e1) {
            System.out.println("64 currentStack=" + currentStack);
            e1.printStackTrace();
        }
        currentStack--;

        notify();
        return el1;
    }

    private synchronized Pair outPair2() throws NullPointerException {
        while (currentStack == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Pair el2 = (Pair) queue.poll(); //peek();
        currentStack--;
        notify();

        return el2;
    }

    @Override
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {
        //sort(queue(in));

        //Object frAccNumber = super.getAccounts();//.getClass(); //getAccIntNumber();

        //Class<? extends String> toAccNumber = toAccountNum.getClass();
        /*
        try {
            inPair(fromAccountNum, toAccountNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Pair el1 = outPair1();
            Pair el2 = outPair2();
            sort(el1, el2);
            fromAccountNum = (String) el1.first;
            toAccountNum = (String) el1.second;

        } catch (Exception e2) {
            e2.printStackTrace();
        }

        currentStack++;

         */
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