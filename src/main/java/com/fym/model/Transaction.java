package com.fym.model;
import com.fym.model.Account;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

public class Transaction{
    private String type; // Income, Expense private Account account; 
    private Account account;
    private String category;
    private double amount;
    private String note;
    private LocalDate dateTime;
    private UUID id;

     public Transaction(String type, Account account, String category, double amount, String note, LocalDate dateTime){
        this.type = type;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
        id = UUID.randomUUID();
    }
     public Transaction(String type, Account account, String category, double amount, String note, LocalDate dateTime, UUID id){
        this.type = type;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
        this.id = id;
    }
    public void setDateTime(LocalDate dateTime){
        this.dateTime = dateTime;
    }
    public LocalDate getDateTime(){
        return dateTime;
    }
    public UUID getID(){
        return id;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
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
    
}
