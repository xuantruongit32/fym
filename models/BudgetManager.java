import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class BudgetManager{
    private List<Account> accounts;
    private List<String> categories;
    private List<Transaction> transactions;
    private List<Tranfer> tranfers;

    BudgetManager(){
        accounts = new ArrayList<>();
        accounts.add(new Account("Bank",0));
        accounts.add(new Account("Cash",0));
        accounts.add(new Account("Card",0));
        categories = new ArrayList<>(Arrays.asList("Food", "Transportation", "Entertainment"));
    }
        void addAccount(String name, double balance){
            Account newAccount = new Account(name, balance);
            accounts.add(newAccount);
        }
        void removeAccount(Account name){
            accounts.remove(name);
        }
        void addCategory(String name) {
            categories.add(name);
        }
        void removeCategory(String name){
            categories.remove(name);
        }
        void addTransaction(String type, Account account, String category, double amount, String note){
            Transaction newTransaction = new Transaction(type,account,category,amount,note);
            transactions.add(newTransaction);
            if(type=="Income"){
                double presentBalance = account.getBalance();
                double newBalance = presentBalance + amount;
                account.setBalance(newBalance);
            }
            if(type=="Expense"){
                double presentBalance = account.getBalance();
                double newBalance = presentBalance - amount;
                account.setBalance(newBalance);
            }
        }
        void removeTransaction(Transaction transaction){
            transactions.remove(transaction);
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
        

    }
