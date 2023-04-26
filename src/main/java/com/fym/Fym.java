package com.fym;
import com.fym.gui.*;
import com.fym.model.BudgetManager;
import java.io.*;

import java.time.LocalDate;
import java.util.UUID;


public class Fym {
    static BudgetManager b = new BudgetManager(); // Declare the BudgetManager object as a global variable
    
    public static void main(String args[]) throws IOException {
        // Add accounts to the BudgetManager object
        b.addAccount("Cash", 100);
        b.addAccount("Bank", 100);
        
        // Create and display the GUI
        Home t = new Home();
        t.setVisible(true);
        
        // Print all accounts to the console
       // System.out.println(b.showAllAccount());
    }
}
