import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class BudgetManager{
    private List<Account> accounts;
    private List<String> categories;

    public BudgetManager(){
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

    }
