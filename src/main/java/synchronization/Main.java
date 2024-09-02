package synchronization;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Account a = new Account("A", 100);
        Account b = new Account("B");

        Bank bank = new Bank();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(bank.transferMoney(a, b, 100, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bank.transferMoney(a,b,100,0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                };
            }
        });
        System.out.println("A har nu: " + a.getBalance() + " kr.");
        System.out.println("B har nu: " + b.getBalance() + " kr.");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("A har nu: " + a.getBalance() + " kr.");
        System.out.println("B har nu: " + b.getBalance() + " kr.");
    }
}
