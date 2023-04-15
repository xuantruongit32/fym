import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;
public class IO{
    public String filePath;
    IO(String filePath){
        this.filePath=filePath;
    }
    IO(){}
    public void check() throws IOException{
        File file = new File(filePath);
        if (!file.exists()){
            file.createNewFile();
        }
    }
    public void writeFile (String content)throws IOException{
        check();
        FileWriter writeAccount = new FileWriter(filePath,true);
        writeAccount.write(content);
        writeAccount.close();
    }
    public void writeAccount(BudgetManager b) throws IOException{
        File file = new File("../database/accounts.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = br.readLine()) != null){
            String[] words = line.split(",");
            String [] word = words[0].split(":");
            String [] word1 = words[1].split(":");
            String name = word[1].substring(1);
            double balance = Double.parseDouble(word1[1]);
            Account newAccount = new Account(name, balance);
            b.accounts.put(name,newAccount);
    }

    }
    public void updateFile(BudgetManager b) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter("../database/accounts.txt"));
            for(Map.Entry<String, Account> entry : b.accounts.entrySet()) {
                writer.write("Account name: " + entry.getValue().getName() + "," + " balance:" + entry.getValue().getBalance() + "\n");
            }
            writer.close();
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("../database/transaction.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("../database/income.txt"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("../database/expense.txt"));
            for(Map.Entry<String, Transaction> entry : b.transactions.entrySet()) {
                if(entry.getKey().equals("Income")){
                    writer1.write("Type: " + entry.getValue().getType() + "," + " Account: " + entry.getValue().getAccount().getName()+ "," + " Category: " + entry.getValue().getCategory() + ","+ "Amount:"+entry.getValue().getAmount()+","+"Note: "+entry.getValue().getNote()+"\n");
                    writer2.write("Type: " + entry.getValue().getType() + "," + " Account: " + entry.getValue().getAccount().getName()+ "," + " Category: " + entry.getValue().getCategory() + ","+ "Amount:"+entry.getValue().getAmount()+","+"Note: "+entry.getValue().getNote()+"\n");
            }
                else if(entry.getKey().equals("Expense")){
                    writer1.write("Type: " + entry.getValue().getType() + "," + " Account: " + entry.getValue().getAccount().getName()+ "," + " Category: " + entry.getValue().getCategory() + ","+ "Amount:"+entry.getValue().getAmount()+","+"Note: "+entry.getValue().getNote()+"\n");
                    writer3.write("Type: " + entry.getValue().getType() + "," + " Account: " + entry.getValue().getAccount().getName()+ "," + " Category: " + entry.getValue().getCategory() + ","+ "Amount:"+entry.getValue().getAmount()+","+"Note: "+entry.getValue().getNote()+"\n");
            }
        }
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("../database/tranfer.txt"));
        for(Tranfer tranfer :b.tranfers){
            writer4.write("Type: Tranfer" + "," + "Previous Account: " + tranfer.getPreviousAccount().getName()+ "," + "New Account: " + tranfer.getNewAccount().getName() + ","+ "Amount:"+tranfer.getAmount()+","+"Note: "+tranfer.getNote()+"\n");
        }
            writer1.close();
            writer2.close();
            writer3.close();
            writer4.close();
        

}
}
