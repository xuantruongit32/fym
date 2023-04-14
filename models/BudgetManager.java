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
    protected Map<String,Account> accounts;
    protected List<String> categories;
    protected Map<String,Transaction> transactions; //1:Income, 2:Expense
    protected List<Tranfer> tranfers;

    public BudgetManager(){
        accounts = new HashMap<>();
        categories = new ArrayList<>(Arrays.asList("Food", "Transportation", "Entertainment"));
        transactions = new HashMap<>();
        tranfers = new ArrayList<>();
    }
        public void addAccount(String name, double balance) throws IOException{
            Account newAccount = new Account(name, balance);
            accounts.put(name,newAccount);
            String file = "../database/accounts.txt";
            IO accountIO = new IO(file);
            accountIO.writeFile("Account name: " + name + "," + " balance: " + balance +"\n");

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
        public void addCategory(String name) throws IOException {
            categories.add(name);
            String file ="../database/category.txt";
            IO categoryIO = new IO(file);
            categoryIO.writeFile("Category: " + name + "\n");

        }
        public void removeCategory(String name){
            categories.remove(name);
        }
        public void addTransaction(String type, Account account, String category, double amount, String note) throws IOException{
            Transaction newTransaction = new Transaction(type,account,category,amount,note);
            transactions.put(type,newTransaction);
            if(type.equals("Income")){
                String file = "../database/income.txt";
                IO accountIO = new IO(file);
                accountIO.writeFile("Type: " + type + "," + " Account: " + account.getName()+ "," + " Category: " + category + ","+ "Amount:"+amount+","+"Note: "+note+"\n");
                double presentBalance = account.getBalance();
                double newBalance = presentBalance + amount;
                account.setBalance(newBalance);
            }
            if(type.equals("Expense")){
                double presentBalance = account.getBalance();
                double newBalance = presentBalance - amount;
                account.setBalance(newBalance);
                String file = "../database/expense.txt";
                IO accountIO = new IO(file);
                accountIO.writeFile("Type: " + type + "," + " Account: " + account.getName()+ "," + " Category: " + category + ","+ "Amount:"+amount+","+"Note: "+note+"\n");
            }
        }
        public void removeTransaction(String transaction){
            transactions.remove(transaction);
        }
        public void showAllTransaction() throws IOException{
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
        public void addTranfer(Account previousAccount, Account newAccount, double amount, String note) throws IOException
        {
            Tranfer newTranfer = new Tranfer(previousAccount, newAccount, amount, note);
            tranfers.add(newTranfer);
            double presentPreviousAccountBalance = previousAccount.getBalance();
            double presentNewAccountBalance = newAccount.getBalance();
            double newPreviousAccountBalance = presentPreviousAccountBalance - amount;
            double newNewAccountBalance = presentNewAccountBalance + amount;
            previousAccount.setBalance(newPreviousAccountBalance);
            newAccount.setBalance(newNewAccountBalance);
            String file = "../database/tranfer.txt";
            IO accountIO = new IO(file);
            accountIO.writeFile("Type: Tranfer" + "," + "Previous Account: " + previousAccount.getName()+ "," + "New Account: " + newAccount.getName() + ","+ "Amount:"+amount+","+"Note: "+note+"\n");
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

