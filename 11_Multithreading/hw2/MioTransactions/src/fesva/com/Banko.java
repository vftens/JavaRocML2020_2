package fesva.com;

import java.util.HashMap;
import java.util.Random;

public class Banko {
    private HashMap<String, Accounti> accounts;
    private final Random random = new Random();

    public Object getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Accounti> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        System.out.printf("...Идет проверка (%s -> %s, %d)", fromAccountNum, toAccountNum, amount);
        Thread.sleep(1001); // more than 1000
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Accounti from = accounts.get(fromAccountNum);
        Accounti to = accounts.get(toAccountNum);
        System.out.printf("%s >> %s (%d)", from.getAccNumber(), to.getAccNumber(), amount);
        if (!isChecked(from, to, amount)) {
            return;
        }

        decreaseMoney(from, amount);
        increaseMoney(to, amount);

        try {
            if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                from.setBlock(true);
                to.setBlock(true);
                System.out.printf("...Неудача!" +
                        "\nСчета %s и %s заблокированы службой безопасности\n", from.getAccNumber(), to.getAccNumber());
            } else {
                System.out.println("...Успешно");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    private boolean isChecked(Accounti from, Accounti to, long value) {
        if (from.isBlock() || to.isBlock()) {
            System.out.println("...Один из счетов заблокирован");
            return false;
        }

        if (!(from.getMoney() >= value && value > 0)) {
            System.out.println("...Неверная сумма или недостаточно средств");
            return false;
        }

        return true;
    }

    private void increaseMoney(Accounti account, long amount) {
        account.setMoney(account.getMoney() + amount);
    }

    private void decreaseMoney(Accounti account, long amount) {
        account.setMoney(account.getMoney() - amount);
    }
}
