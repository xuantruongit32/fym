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
    protected HashMap<String,List<Transaction>> transactions; 
    protected List<Tranfer> tranfers;

    public BudgetManager(){
        accounts = new HashMap<>();
        categories = new ArrayList<>();
        transactions = new HashMap<>();
        transactions.put("Income", new ArrayList<>());
        transactions.put("Expense", new ArrayList<>());
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
    public void addTransaction(String type, Account account, String category, double amount, String note, boolean update) {
        Transaction newTransaction = new Transaction(type, account, category, amount, note);
        transactions.get(type).add(newTransaction);
        if(update  == true){
            double presentBalance = account.getBalance();
            double newBalance = presentBalance + (type.equals("Income") ? amount : -amount);
            account.setBalance(newBalance);
    }
    }

/*    public void removeTransaction(String type, int index) {
        List<Transaction> transactionList = transactions.get(type);
        if (index >= 0 && index < transactionList.size()) {
            Transaction transaction = transactionList.remove(index);
            Account account = transaction.getAccount();
            double presentBalance = account.getBalance();
            double newBalance = presentBalance - (transaction.getType().equals("Income") ? transaction.getAmount() : -transaction.getAmount());
            account.setBalance(newBalance);
        }
    }
    */

    public void showAllTransactions() {
        for (List<Transaction> transactionList : transactions.values()) {
            for (Transaction transaction : transactionList) {
            System.out.println("Type: " +transaction.getType()+" ,Category: " +transaction.getCategory()+ ", Balance: " + transaction.getAmount());
            }
        }
    }

    public void showAllIncome() {
        List<Transaction> incomeList = transactions.get("Income");
        double totalIncome = 0;
        for (Transaction transaction : incomeList) {
            System.out.println("Type: " +transaction.getType() + "Balance: " + transaction.getAmount());
            totalIncome += transaction.getAmount();
        }
        System.out.println("Total Income: " + totalIncome);
    }

    public void showAllExpenses() {
        List<Transaction> expenseList = transactions.get("Expense");
        double totalExpenses = 0;
        for (Transaction transaction : expenseList) {
            System.out.println("Type: " +transaction.getType() + "Balance: " + transaction.getAmount());
            totalExpenses += transaction.getAmount();
        }
        System.out.println("Total Expenses: " + totalExpenses);
    }
        public void addTranfer(Account previousAccount, Account newAccount, double amount, String note, boolean update)
        {
            Tranfer newTranfer = new Tranfer(previousAccount, newAccount, amount, note);
            tranfers.add(newTranfer);
            if (update = true){
                double presentPreviousAccountBalance = previousAccount.getBalance();
                double presentNewAccountBalance = newAccount.getBalance();
                double newPreviousAccountBalance = presentPreviousAccountBalance - amount;
                double newNewAccountBalance = presentNewAccountBalance + amount;
                previousAccount.setBalance(newPreviousAccountBalance);
                newAccount.setBalance(newNewAccountBalance);
            
        }
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

