package fesva.com;

import java.util.HashMap;

public class Bank extends Banko{

    private HashMap<String, Account> accounts;

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Bank(Object accounts) {
        Object lock = new Object();

        synchronized(lock) {
            synchronized(lock) {
                synchronized(lock) {
                    // ad nauseam and within method calls
                }
            }
        }

    }

    @Override
    public Object getAccounts() {
        return super.getAccounts();
    }

    @Override
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        return super.isFraud(fromAccountNum, toAccountNum, amount);
    }

    @Override
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {
        super.transfer(fromAccountNum, toAccountNum, amount);
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