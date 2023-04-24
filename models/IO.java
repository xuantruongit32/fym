import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.UUID;
public class IO{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public void importFile(BudgetManager b) throws IOException{
        File accountFile = new File("../database/accounts.txt");
        if(!accountFile.exists())
            accountFile.createNewFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(accountFile)));
        String line;
        while ((line = br.readLine()) != null){
            String[] words = line.split(",");
            String [] word = words[0].split(":");
            String [] word1 = words[1].split(":");
            String [] word2 = words[2].split(":");
            String name = word[1].trim();
            UUID id = UUID.fromString(word2[1].trim());
            double balance = Double.parseDouble(word1[1]);
            b.addAccount(name, balance, id);
    }
        File categoryFile = new File("../database/category.txt");
        if(!categoryFile.exists())
            categoryFile.createNewFile();
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(categoryFile)));
        while ((line = br1.readLine()) != null){
            String [] words = line.split(":");
            String  category = words[1];
            b.addCategory(category);
    }
    File transactionFile = new File("../database/transaction.txt");
        if(!transactionFile.exists())
            transactionFile.createNewFile();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(transactionFile)));
        while ((line = br2.readLine()) != null){
            String [] words = line.split(",");
            String [] word = words[0].split(":");
            String type = word[1].trim();
            String [] word1 = words[1].split(":");
            String account = word1[1].trim();
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
            b.addTransaction(type,b.accounts.get(account),category,amount,note,false,date,id);
    }
    File tranferFile = new File("../database/tranfer.txt");
        if(!tranferFile.exists())
            tranferFile.createNewFile();
        BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(tranferFile)));
        while ((line = br3.readLine()) != null){
            String [] words = line.split(",");
            String [] word2 = words[1].split(":");
            String previousAccount = word2[1].trim();
            String [] word3 = words[2].split(":");
            String newAccount = word3[1].trim();
            String [] word4 = words[3].split(":");
            double amount = Double.parseDouble(word4[1].trim());
            String [] word5 = words[4].split(":");
            String note = word5[1].trim();
            String [] word6 = words[5].split(":");
            LocalDate date = LocalDate.parse(word6[1].trim(),formatter);
            String [] word7 = words[6].split(":");
            UUID id = UUID.fromString(word7[1].trim());
            b.addTranfer(b.accounts.get(previousAccount),b.accounts.get(newAccount),amount,note,false,date, id);
    }
    }
    public void updateFile(BudgetManager b) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter("../database/accounts.txt"));
            for(Map.Entry<String, Account> entry : b.accounts.entrySet()) {
                writer.write("Account name: " + entry.getValue().getName() + "," + " balance:" + entry.getValue().getBalance() + ", ID: "+entry.getValue().getID()+"\n");
            }
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("../database/transaction.txt"));
for(Map.Entry<String, List<Transaction>> entry : b.transactions.entrySet()) {
    for(Transaction transaction : entry.getValue()) {
        writer1.write("Type: " + transaction.getType() + "," + " Account: " + transaction.getAccount().getName()+ "," + " Category: " + transaction.getCategory() + ","+ "Amount:"+transaction.getAmount()+","+"Note: "+transaction.getNote()+", Date: "+ transaction.getDateTime()+", ID: "+transaction.getID()+"\n");
    }
}
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("../database/tranfer.txt"));
        for(Tranfer tranfer :b.tranfers){
            writer4.write("Type: Tranfer" + "," + "Previous Account: " + tranfer.getPreviousAccount().getName()+ "," + "New Account: " + tranfer.getNewAccount().getName() + ","+ "Amount:"+tranfer.getAmount()+","+"Note: "+tranfer.getNote()+", Date: "+tranfer.getDateTime()+", ID: "+tranfer.getID()+"\n");
        }
        BufferedWriter writer5 = new BufferedWriter(new FileWriter("../database/category.txt"));
        for (String category : b.categories){
            writer5.write("Category :"+ category +"\n");
        }
            writer.close();
            writer1.close();
            writer4.close();
            writer5.close();
        

}
}
