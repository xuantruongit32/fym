package com.fym.model;
import com.fym.model.Account;
import java.time.LocalDate;
import java.util.UUID;

public class Tranfer{
    private Account previousAccount; // Have account class
    private Account newAccount; // Have account class
    private double amount;
    private String note;
    private LocalDate dateTime;
    private UUID id;

     public Tranfer(Account previousAccount, Account newAccount, double amount, String note, LocalDate dateTime){
        this.previousAccount = previousAccount;
        this.newAccount = newAccount;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
        id = UUID.randomUUID();
    }
     public Tranfer(Account previousAccount, Account newAccount, double amount, String note, LocalDate dateTime, UUID id){
        this.previousAccount = previousAccount;
        this.newAccount = newAccount;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
        this.id = id;
    }
    public LocalDate getDateTime(){
        return dateTime;
    }
    public void setDateTime(LocalDate dateTime){
        this.dateTime = dateTime;
    }
    public Account getPreviousAccount(){
        return previousAccount;
    }
    public void setPreviousAccount(Account previousAccount){
        this.previousAccount = previousAccount;
    }
    public Account getNewAccount(){
        return newAccount;
    }
    public void setNewAccount(Account newAccount){
        this.newAccount = newAccount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setNote(String note){
        this.note = note;
    }
    public String getNote(){
        return note;
    }
    public UUID getID(){
        return id;
    }
    
}

