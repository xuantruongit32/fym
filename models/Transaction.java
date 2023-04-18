import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class Transaction{
    private String type; // Income, Expense private Account account; 
    private Account account;
    private String category;
    private double amount;
    private String note;
    private LocalDateTime dateTime;

     public Transaction(String type, Account account, String category, double amount, String note, LocalDateTime dateTime){
        this.type = type;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
    }
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    public LocalDateTime getDateTime(LocalDateTime dateTime){
        return dateTime;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setNote(String note){
        this.note = note;
    }
    public String getNote(){
        return note;
    }
    
}
