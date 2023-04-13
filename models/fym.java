import java.io.*;
import java.util.Scanner;
public class fym{
    public static void main(String args[]) throws IOException{
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addTransaction("Income", budgetManager.getAccount("Cash"), "Food", 12, "Test");
        budgetManager.addTransaction("Expense", budgetManager.getAccount("Cash"), "Food", 1, "Test");
        budgetManager.addTranfer(budgetManager.getAccount("Cash"),budgetManager.getAccount("Bank"), 10, "he");
//        budgetManager.removeAccount();
        budgetManager.addAccount();
        budgetManager.addCategory("Food");
        budgetManager.showAllTransaction();
        budgetManager.showAllIncome();
        budgetManager.showAllExpense();
        budgetManager.showAllTranfer();
        budgetManager.showAllAccount();
    }
}
