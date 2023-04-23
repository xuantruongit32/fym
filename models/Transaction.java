import java.time.LocalDateTime;
import java.time.LocalDate;

public class Transaction{
    private String type; // Income, Expense private Account account; 
    private Account account;
    private String category;
    private double amount;
    private String note;
    private LocalDate dateTime;

     public Transaction(String type, Account account, String category, double amount, String note, LocalDate dateTime){
        this.type = type;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
    }
    public void setDateTime(LocalDate dateTime){
        this.dateTime = dateTime;
    }
    public LocalDate getDateTime(){
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
