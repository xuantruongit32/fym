import java.io.*;
import java.time.LocalDateTime;
public class fym{
    public static void main(String args[]) throws IOException{
        BudgetManager budgetManager = new BudgetManager();
        IO io = new IO();
//        io.importFile(budgetManager);
//        budgetManager.addAccount("Cash", 100);
 //       budgetManager.addAccount("Bank", 100);
 //       budgetManager.addCategory("Food");
       budgetManager.addTransaction("Income", budgetManager.getAccount("Cash"), "Food", 20, "Mom",true,LocalDateTime.now());
        budgetManager.addTransaction("Expense", budgetManager.getAccount("Cash"), "Food", 10, "Rice",true, LocalDateTime.now());
        budgetManager.addTranfer(budgetManager.getAccount("Cash"),budgetManager.getAccount("Bank"), 10, "he",true, LocalDateTime.now());
//        budgetManager.removeAccount();
//        budgetManager.showAllIncome();
//        budgetManager.showAllExpense();
//        budgetManager.showAllTranfer();
        budgetManager.showAllTransactions();
        budgetManager.showAllCategory();
        budgetManager.showAllAccount();
//       io.updateFile(budgetManager);
    }
}
