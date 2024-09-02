package synchronization;

public class Account {
    private double balance;
    private String owner;

    public Account(String owner){
        this(owner,0);
    }

    public Account(String owner, double balance){
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }




    public String getOwner(){
        return owner;
    }

    public double getBalance(){
        return balance;
    }
}
