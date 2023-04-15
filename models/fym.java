import java.io.*;
import java.util.Scanner;
public class fym{
    public static void main(String args[]) throws IOException{
        BudgetManager budgetManager = new BudgetManager();
        IO io = new IO();
        io.writeAccount(budgetManager);
//        budgetManager.addAccount("Test", 5);
//        budgetManager.addAccount("Test1", 8);
//        budgetManager.addAccount("Test4", 9);
       budgetManager.addTransaction("Income", budgetManager.getAccount("Cash"), "Food", 120, "Test1");
        budgetManager.addTransaction("Expense", budgetManager.getAccount("Cash"), "Food", 10, "Test2");
        budgetManager.addTranfer(budgetManager.getAccount("Cash"),budgetManager.getAccount("Bank"), 10, "he");
//        budgetManager.removeAccount();
//        budgetManager.addAccount();
//        budgetManager.showAllIncome();
//        budgetManager.showAllExpense();
//        budgetManager.showAllTranfer();
//        budgetManager.showAllTransaction();
        budgetManager.addCategory("Food");
        io.updateFile(budgetManager);
//        budgetManager.showAllAccount();
    }
}
