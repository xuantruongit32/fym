import java.io.*;

public class File{
    public static void main(String [] args){
    try{
        FileInputStream fis = new FileInputStream("database/input.txt");
        fis.close();
    }
    catch (IOException e){
        System.out.println("Error");
        e.printStackTrace();
    }
    }

        
}
