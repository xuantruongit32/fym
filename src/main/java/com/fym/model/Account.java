package com.fym.model;

import java.io.*;
import java.util.UUID;

public class Account{
    private String name;
    private double balance;
    private UUID id;

    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    public Account(String name, double balance, UUID id){
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
