package synchronization;

public class Bank {


    public boolean  transferMoney(Account from, Account to, double amount, int pauseFor) throws InterruptedException {

        if(from.getBalance() - amount < 0)
            return false;
        else{
            Thread.sleep(pauseFor);
            from.withdraw(amount);
            to.deposit(amount);
            return true;
        }

    }
}
