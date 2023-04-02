class Account{
    private String name;
    private double balance;

    Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setBalance(double balance){
        this.balance = balance;
    }
    double getBalance(){
        return balance;
    }
}
