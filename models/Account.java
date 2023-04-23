import java.io.*;
import java.util.UUID;

public class Account{
    private String name;
    private double balance;
    private UUID id;

    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
        id = UUID.randomUUID();
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
    public UUID getID(){
        return id;
    }
}
