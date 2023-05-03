package com.fym;
import com.fym.gui.*;
import com.fym.model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.UUID;


public class Fym {
    public static BudgetManager b = new BudgetManager(); // Declare the BudgetManager object as a global variable
    public static void main(String args[]) throws IOException {
        IO io = new IO();
        io.importFile(b);
//        b.addAccount("Cash", 100);
 //       b.addAccount("Bank", 100);
     
 //       b.addTransaction("Income",b.getAccount("497e103d-203b-4989-9efa-45d4173276ef"),"Food",37,"test",true,LocalDate.now());
   //     b.removeAccount("d45c3698-c6f0-465c-8745-58f2eef640a8");
// b.removeTransaction("Income", "00056fe3-23f4-414c-92ad-3c021800f99a");
        
        // Create and display the GUI
       Home t = new Home(b);
        t.setVisible(true);

            

        
    }
}
