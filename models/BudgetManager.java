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
    private Map<String,Account> accounts;
    private List<String> categories;
    private Map<String,Transaction> transactions; //1:Income, 2:Expense
    private List<Tranfer> tranfers;

    public BudgetManager(){
        accounts = new HashMap<>();
        accounts.put("Bank",new Account("Bank",0));
        accounts.put("Cash",new Account("Cash",0));
        accounts.put("Card",new Account("Card",0));
        categories = new ArrayList<>(Arrays.asList("Food", "Transportation", "Entertainment"));
        transactions = new HashMap<>();
        tranfers = new ArrayList<>();
    }
        public void addAccount() throws IOException{
            System.out.println("Name of Account want to add: ");
            Scanner scanner= new Scanner(System.in);
            String name = scanner.nextLine(); 
            System.out.println("Number of Balance: ");
            Scanner scanner1= new Scanner(System.in);
            double balance = scanner1.nextDouble(); 
            Account newAccount = new Account(name, balance);
            accounts.put(name,newAccount);
            String fileName = "accounts.txt";
            String filePath = "/home/v/projects/first/fym/database/" + fileName;
            Path path = Paths.get(filePath);
            if(!Files.exists(path)){
                Files.createFile();
            }
            FileWriter writeAccount = new FileWriter("../database/accounts.txt");
            writeAccount.write("Account name: "+name + "Balance: "+balance + "\n");
            writeAccount.close();
            scanner.close();
            scanner1.close();
            writeAccount.close();

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
        public void addCategory(String name) {
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
        


    }

