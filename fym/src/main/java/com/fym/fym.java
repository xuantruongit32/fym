import com.fym.gui.*;
import com.fym.models.*;


import java.io.*;
import java.time.LocalDate;
import java.util.UUID;
import javax.swing.JPanel;
import javax.swing.JFrame;
public class fym{
    
    public static void main(String args[]) throws IOException{
        BudgetManager budgetManager = new BudgetManager();
        IO io = new IO();
        io.importFile(budgetManager);
//        budgetManager.addAccount("Cash", 100);
//        budgetManager.addAccount("Bank", 100);
 //       budgetManager.addCategory("Food");
//       budgetManager.addTransaction("Income", budgetManager.getAccount("Cash"), "Food", 20, "Mom",true,LocalDate.now());
//        budgetManager.addTransaction("Expense", budgetManager.getAccount("Cash"), "Food", 10, "Rice",true, LocalDate.now());
//        budgetManager.addTranfer(budgetManager.getAccount("Cash"),budgetManager.getAccount("Bank"), 10, "he",true, LocalDate.now());
//        budgetManager.removeAccount();
//        budgetManager.showAllIncome();
//        budgetManager.showAllExpense();
        budgetManager.showAllTranfer();
        budgetManager.removeTranfer("b59e69b8-8e78-42a2-8162-91d1b05993a6");
//        budgetManager.showAllTransactions();
//        budgetManager.showAllCategory();
        budgetManager.showAllAccount();
        JPanel jpanel = new JPanel();
        JFrame jframe = new JFrame();
        jframe.add(jpanel);
        jframe.setVisible(true);
        
       io.updateFile(budgetManager);
    }
}
