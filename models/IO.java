import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
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
}
