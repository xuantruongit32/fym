import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class BudgetManager{
    private Map<String,Account> accounts;
    private List<String> categories;
    private Map<String,Transaction> transactions; //1:Income, 2:Expense
    private List<Tranfer> tranfers;

    BudgetManager(){
        accounts = new HashMap<>();
        accounts.put("Bank",new Account("Bank",0));
        accounts.put("Cash",new Account("Cash",0));
        accounts.put("Card",new Account("Card",0));
        categories = new ArrayList<>(Arrays.asList("Food", "Transportation", "Entertainment"));
        transactions = new HashMap<>();
        tranfers = new ArrayList<>();
    }
        void addAccount(String name, double balance){
            Account newAccount = new Account(name, balance);
            accounts.put(name,newAccount);
        }
        void removeAccount(String name){
            accounts.remove(name);
        }
        Account getAccount(String name){
            return accounts.get(name);
        }
        void showAllAccount(){
            for(Map.Entry<String,Account> entry: accounts.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue().getBalance());
            }
        }
        void addCategory(String name) {
            categories.add(name);
        }
        void removeCategory(String name){
            categories.remove(name);
        }
        void addTransaction(String type, Account account, String category, double amount, String note){
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
        void removeTransaction(String transaction){
            transactions.remove(transaction);
        }
        void showAllTransaction(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }
        void showAllIncome(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                if(entry.getKey()=="Income")
                    System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }
        void showAllExpense(){
            for(Map.Entry<String, Transaction> entry: transactions.entrySet()){
                if(entry.getKey()=="Expense")
                    System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
            }
        }
        void addTranfer(Account previousAccount, Account newAccount, double amount, String note)
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
        void removeTranfer(Tranfer tranfer){
            tranfers.remove(tranfer);
        }
        void showAllTranfer(){
            for(int i=0; i<tranfers.size(); i++){
                System.out.println("Tranfer: " + tranfers.get(i).getAmount());
            }
        }
        

    }
