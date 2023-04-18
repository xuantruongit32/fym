import java.io.*;
import java.util.Scanner;
public class fym{
    public static void main(String args[]) throws IOException{
        BudgetManager budgetManager = new BudgetManager();
        IO io = new IO();
        io.importFile(budgetManager);
//        budgetManager.addAccount("Cash", 100);
 //       budgetManager.addAccount("Bank", 100);
 //       budgetManager.addCategory("Food");
        budgetManager.addTransaction("Income", budgetManager.getAccount("Cash"), "Food", 32, "Salary",true);
        budgetManager.addTransaction("Expense", budgetManager.getAccount("Cash"), "Food", 10, "Fish",true);
        budgetManager.addTranfer(budgetManager.getAccount("Cash"),budgetManager.getAccount("Bank"), 10, "he",true);
//        budgetManager.removeAccount();
//        budgetManager.showAllIncome();
//        budgetManager.showAllExpense();
        budgetManager.showAllTranfer();
        budgetManager.showAllTransactions();
        budgetManager.showAllCategory();
        budgetManager.showAllAccount();
        io.updateFile(budgetManager);
    }
}
