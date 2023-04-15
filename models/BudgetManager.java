import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class BudgetManager{
    protected HashMap<String,Account> accounts;
    protected List<String> categories;
    protected HashMap<String,Transaction> transactions; 
    protected List<Tranfer> tranfers;

    public BudgetManager(){
        accounts = new HashMap<>();
        categories = new ArrayList<>();
        transactions = new HashMap<>();
        tranfers = new ArrayList<>();
    }
        public void addAccount(String name, double balance){
            Account newAccount = new Account(name, balance);
            accounts.put(name,newAccount);

        }
        public void removeAccount(){
            System.out.println("Name of Account want to remove: ");
            Scanner scanner= new Scanner(System.in);
            String name = scanner.nextLine(); 
            accounts.remove(name);
            scanner.close();
        }
        public Account getAccount(String name){
            return accounts.get(name);
        }
        public void showAllAccount(){
            for(Map.Entry<String,Account> entry: accounts.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue().getBalance());
            }
        }
        public void addCategory(String name){
            categories.add(name);
        }
        public void removeCategory(String name){
            categories.remove(name);
        }
        public void addTransaction(String type, Account account, String category, double amount, String note){
            Transaction newTransaction = new Transaction(type,account,category,amount,note);
            transactions.put(type,newTransaction);
            if(type.equals("Income")){
                double presentBalance = account.getBalance();
                double newBalance = presentBalance + amount;
                account.setBalance(newBalance);
            }
            if(type.equals("Expense")){
                double presentBalance = account.getBalance();
                double newBalance = presentBalance - amount;
                account.setBalance(newBalance);
            }
        }
        public void removeTransaction(String transaction){
            transactions.remove(transaction);
        }
        public void showAllTransaction(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }

        public void showAllIncome(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                if(entry.getKey()=="Income")
                    System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }
        public void showAllExpense(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                if(entry.getKey()=="Expense")
                    System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }
        public void addTranfer(Account previousAccount, Account newAccount, double amount, String note)
        {
            Tranfer newTranfer = new Tranfer(previousAccount, newAccount, amount, note);
            tranfers.add(newTranfer);
            double presentPreviousAccountBalance = previousAccount.getBalance();
            double presentNewAccountBalance = newAccount.getBalance();
            double newPreviousAccountBalance = presentPreviousAccountBalance - amount;
            double newNewAccountBalance = presentNewAccountBalance + amount;
            previousAccount.setBalance(newPreviousAccountBalance);
            newAccount.setBalance(newNewAccountBalance);
        }
        public void removeTranfer(Tranfer tranfer){
            tranfers.remove(tranfer);
        }
        public void showAllTranfer(){
            for(int i=0; i<tranfers.size(); i++){
                System.out.println("Tranfer: " + tranfers.get(i).getAmount());
            }
        }
        public void showAllCategory(){
            for(int i=0; i<categories.size(); i++){
                System.out.println("Category: " + categories.get(i));
            }
        }
    }

