package com.fym.model;
import com.fym.model.Account;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;
public class BudgetManager{
    protected HashMap<UUID,Account> accounts;
    protected List<String> categories;
    protected HashMap<String,List<Transaction>> transactions; 
    protected HashMap<UUID,Tranfer> tranfers;
    public static void test(){
        System.out.println("fd");
    }
    public BudgetManager(){ 
        
        accounts = new HashMap<>();
        categories = new ArrayList<>();
        transactions = new HashMap<>();
        transactions.put("Income", new ArrayList<>());
        transactions.put("Expense", new ArrayList<>());
        tranfers = new HashMap<>();
    }
        public void addAccount(String name, double balance){
            Account newAccount = new Account(name, balance);
            accounts.put(newAccount.getID(),newAccount);

        }
        public void addAccount(String name, double balance, UUID id){
            Account newAccount = new Account(name, balance, id);
            accounts.put(newAccount.getID(),newAccount);

        }
        public void removeAccount(String sid){
            UUID id = UUID.fromString(sid);
            removeTranfer(accounts.get(id));
            accounts.remove(id);
        }
        public Account getAccount(String sid){
            UUID id = UUID.fromString(sid);
            return accounts.get(id);
        }
        
        public String showAllAccount(){
            String t="";
            for(Map.Entry<UUID,Account> entry: accounts.entrySet()){
                t+=entry.getValue().getName() + " : " + entry.getValue().getBalance();
            }
            return t;
        }
        public void addCategory(String name){
            categories.add(name);
        }
        public void removeCategory(String name){
            categories.remove(name);
        }
    public void addTransaction(String type, Account account, String category, double amount, String note, boolean update, LocalDate dateTime) {
        Transaction newTransaction = new Transaction(type, account, category, amount, note, dateTime);
        transactions.get(type).add(newTransaction);
        if(update  == true){
            double presentBalance = account.getBalance();
            double newBalance = presentBalance + (type.equals("Income") ? amount : -amount);
            account.setBalance(newBalance);
    }
    }
    public void addTransaction(String type, Account account, String category, double amount, String note, boolean update, LocalDate dateTime, UUID id) {
        Transaction newTransaction = new Transaction(type, account, category, amount, note, dateTime, id);
        transactions.get(type).add(newTransaction);
        if(update  == true){
            double presentBalance = account.getBalance();
            double newBalance = presentBalance + (type.equals("Income") ? amount : -amount);
            account.setBalance(newBalance);
    }
    }

    public void removeTransaction(String type, String sid) {
        UUID id = UUID.fromString(sid);
        List<Transaction> transactionList = transactions.get(type);
        for(int i=0;i<transactionList.size(); i++) {
            if(transactionList.get(i).getID() == id){
                Account account = transactionList.get(i).getAccount();
                double presentBalance = account.getBalance();
                double newBalance = presentBalance - (transactionList.get(i).getType().equals("Income") ? transactionList.get(i).getAmount() : + transactionList.get(i).getAmount());
                account.setBalance(newBalance);
                transactions.get(type).remove(i);
                break;
            }
        }
    }
    public void removeTransaction(Account account) {
        for(Map.Entry<String, List<Transaction>> entry : transactions.entrySet()){
            List<Transaction> transactionList = entry.getValue();
            for(int i=0; i<transactionList.size(); i++){
                if(transactionList.get(i).getAccount() == account)
                    removeTransaction(transactionList.get(i).getType(), transactionList.get(i).getID().toString());
            }
    }
    }
    

    public void showAllTransactions() {
        for (List<Transaction> transactionList : transactions.values()) {
            for (Transaction transaction : transactionList) {
            System.out.println("Type: " +transaction.getType()+" ,Category: " +transaction.getCategory()+ ", Balance: " + transaction.getAmount()+", DateTime: " + transaction.getDateTime());
            }
        }
    }

    public void showAllIncome() {
        List<Transaction> incomeList = transactions.get("Income");
        double totalIncome = 0;
        for (Transaction transaction : incomeList) {
            System.out.println("Type: " +transaction.getType() + "Balance: " + transaction.getAmount() + ", DateTime: "+ transaction.getDateTime());
            totalIncome += transaction.getAmount();
        }
        System.out.println("Total Income: " + totalIncome);
    }

    public void showAllExpenses() {
        List<Transaction> expenseList = transactions.get("Expense");
        double totalExpenses = 0;
        for (Transaction transaction : expenseList) {
            System.out.println("Type: " +transaction.getType() + "Balance: " + transaction.getAmount() + ", DateTime: " + transaction.getDateTime());
            totalExpenses += transaction.getAmount();
        }
        System.out.println("Total Expenses: " + totalExpenses);
    }
        public void addTranfer(Account previousAccount, Account newAccount, double amount, String note, boolean update, LocalDate dateTime)
        {
            Tranfer newTranfer = new Tranfer(previousAccount, newAccount, amount, note, dateTime);
            tranfers.put(newTranfer.getID(),newTranfer);
            if (update == true){
                double presentPreviousAccountBalance = previousAccount.getBalance();
                double presentNewAccountBalance = newAccount.getBalance();
                double newPreviousAccountBalance = presentPreviousAccountBalance - amount;
                double newNewAccountBalance = presentNewAccountBalance + amount;
                previousAccount.setBalance(newPreviousAccountBalance);
                newAccount.setBalance(newNewAccountBalance);
        }
        }
        public void addTranfer(Account previousAccount, Account newAccount, double amount, String note, boolean update, LocalDate dateTime, UUID id)
        {
            Tranfer newTranfer = new Tranfer(previousAccount, newAccount, amount, note, dateTime, id);
            tranfers.put(newTranfer.getID(),newTranfer);
            if (update == true){
                double presentPreviousAccountBalance = previousAccount.getBalance();
                double presentNewAccountBalance = newAccount.getBalance();
                double newPreviousAccountBalance = presentPreviousAccountBalance - amount;
                double newNewAccountBalance = presentNewAccountBalance + amount;
                previousAccount.setBalance(newPreviousAccountBalance);
                newAccount.setBalance(newNewAccountBalance);
        }
        }
        public void removeTranfer(String sid){
            UUID id = UUID.fromString(sid);
            double newValue = tranfers.get(id).getPreviousAccount().getBalance() + tranfers.get(id).getAmount();
            tranfers.get(id).getPreviousAccount().setBalance(newValue);newValue = newValue = tranfers.get(id).getPreviousAccount().getBalance() - tranfers.get(id).getAmount();
            tranfers.get(id).getNewAccount().setBalance(newValue);
            tranfers.remove(id);
        }
        public void removeTranfer(Account account){
            for(Map.Entry<UUID, Tranfer> entry : tranfers.entrySet()){
                if(entry.getValue().getPreviousAccount() == account){
                    double newValue = entry.getValue().getNewAccount().getBalance() - entry.getValue().getAmount();
                    entry.getValue().getNewAccount().setBalance(newValue);
                    tranfers.remove(entry);
                }
                if(entry.getValue().getNewAccount() == account){
                    double newValue = entry.getValue().getPreviousAccount().getBalance() + entry.getValue().getAmount();
                    entry.getValue().getPreviousAccount().setBalance(newValue);
                     tranfers.remove(entry);
                }
            }
        }
        public void showAllTranfer(){
            for(Map.Entry<UUID, Tranfer> entry : tranfers.entrySet()){
                System.out.println("Tranfer: " + entry.getValue().getAmount() + ", PreviousAccount: " + entry.getValue().getPreviousAccount().getName() + ", newAccount: " + entry.getValue().getNewAccount().getName() + ", note: " + entry.getValue().getNote() + ", DateTime: " + entry.getValue().getDateTime() );
            }
        }
        public void showAllCategory(){
            for(int i=0; i<categories.size(); i++){
                System.out.println("Category: " + categories.get(i));
            }
        }
    }

