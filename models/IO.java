import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class IO{
    public String filePath;
    IO(String filePath){
        this.filePath=filePath;
    }
    void check() throws IOException{
        File file = new File(filePath);
        if (!file.exists()){
            file.createNewFile();
        }
    }
    public void writeFile (String content)throws IOException{
        FileWriter writeAccount = new FileWriter(filePath,true);
        writeAccount.write(content);
        writeAccount.close();
    }

}
