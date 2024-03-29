package com.fym.model;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.UUID;
public class IO{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public void importFile(BudgetManager b) throws IOException{
        File accountFile = new File("/home/v/projects/first/fym/src/main/java/database/accounts.txt");
        if(!accountFile.exists())
            accountFile.createNewFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(accountFile)));
        String line;
        while ((line = br.readLine()) != null){
            String[] words = line.split(",");
            String [] word = words[0].split(":");
            String [] word1 = words[1].split(":");
            String name = word[1].trim();
            double balance = Double.parseDouble(word1[1]);
            b.addAccount(name, balance);
    }
        File categoryFile = new File("/home/v/projects/first/fym/src/main/java/database/category.txt");
        if(!categoryFile.exists())
            categoryFile.createNewFile();
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(categoryFile)));
        while ((line = br1.readLine()) != null){
            String [] words = line.split(",");
            String  [] word = words[0].split(":");
            String category = word[1].trim();
            String [] word1 = words[1].split(":");
            String type = word1[1].trim();
            b.addCategory(category, type);
    }
    File transactionFile = new File("/home/v/projects/first/fym/src/main/java/database/transaction.txt");
        if(!transactionFile.exists())
            transactionFile.createNewFile();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(transactionFile)));
        while ((line = br2.readLine()) != null){
            String [] words = line.split(",");
            String [] word = words[0].split(":");
            String type = word[1].trim();
            String [] word1 = words[1].split(":");
            String  accountName = word1[1].trim();
            String [] word2 = words[2].split(":");
            String category = word2[1].trim();
            String [] word3 = words[3].split(":");
            double amount = Double.parseDouble(word3[1]);
            String [] word4 = words[4].split(":");
            String note = word4[1].trim();
            String [] word5 = words[5].split(":");
            LocalDate date = LocalDate.parse(word5[1].trim(),formatter);
            String [] word6 = words[6].split(":");
            UUID id = UUID.fromString(word6[1].trim());
            b.addTransaction(type,b.accounts.get(accountName),category,amount,note,false,date,id);
    }
    File tranferFile = new File("/home/v/projects/first/fym/src/main/java/database/tranfer.txt");
        if(!tranferFile.exists())
            tranferFile.createNewFile();
        BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(tranferFile)));
        while ((line = br3.readLine()) != null){
            String [] words = line.split(",");
            String [] word2 = words[1].split(":");
            String previousAccountName = word2[1].trim();
            String [] word3 = words[2].split(":");
            String newAccountName = word3[1].trim();
            String [] word4 = words[3].split(":");
            double amount = Double.parseDouble(word4[1].trim());
            String [] word5 = words[4].split(":");
            String note = word5[1].trim();
            String [] word6 = words[5].split(":");
            LocalDate date = LocalDate.parse(word6[1].trim(),formatter);
            String [] word7 = words[6].split(":");
            UUID id = UUID.fromString(word7[1].trim());
            b.addTranfer(b.accounts.get(previousAccountName),b.accounts.get(newAccountName),amount,note,false,date, id);
    }
    }
    public void updateFile(BudgetManager b) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/v/projects/first/fym/src/main/java/database/accounts.txt"));
            for(Map.Entry<String, Account> entry : b.accounts.entrySet()) {
                writer.write("Account name: " + entry.getValue().getName() + "," + " balance:" + entry.getValue().getBalance() +"\n");
            }
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("/home/v/projects/first/fym/src/main/java/database/transaction.txt"));
for(Map.Entry<String, List<Transaction>> entry : b.transactions.entrySet()) {
    for(Transaction transaction : entry.getValue()) {
        writer1.write("Type: " + transaction.getType() + ", Account name: "+ transaction.getAccount().getName()+", Category: " + transaction.getCategory() + ","+ "Amount:"+transaction.getAmount()+","+"Note: "+transaction.getNote()+", Date: "+ transaction.getDateTime()+", ID: "+transaction.getID()+"\n");
    }
}
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("/home/v/projects/first/fym/src/main/java/database/tranfer.txt"));
for(Map.Entry<UUID, Tranfer> entry : b.tranfers.entrySet()) {
    writer4.write("Type: Tranfer" + ", Previous Account name:"+ entry.getValue().getPreviousAccount().getName()+ ", New Account name: "+ entry.getValue().getNewAccount().getName()+","+ "Amount:"+entry.getValue().getAmount()+","+"Note: "+entry.getValue().getNote()+", Date: "+entry.getValue().getDateTime()+", ID: "+entry.getValue().getID()+"\n");
}
        BufferedWriter writer5 = new BufferedWriter(new FileWriter("/home/v/projects/first/fym/src/main/java/database/category.txt"));
for (String category : b.categoriesIncome){
    writer5.write("Category :"+ category +", Type: Income"+"\n");
        }
for (String category : b.categoriesExpense){
    writer5.write("Category :"+ category +", Type: Expense"+"\n");
        }
            writer.close();
            writer1.close();
            writer4.close();
            writer5.close();
        

}
}
