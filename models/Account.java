public class Account{
    private String name;
    private double balance;

    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
}
