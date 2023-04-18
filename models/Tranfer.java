import java.time.DateTimeException;

public class Tranfer{
    private Account previousAccount; // Have account class
    private Account newAccount; // Have account class
    private double amount;
    private String note;
    private DateTimeException dateTime;

     public Tranfer(Account previousAccount, Account newAccount, double amount, String note, DateTimeException dateTime){
        this.previousAccount = previousAccount;
        this.newAccount = newAccount;
        this.amount = amount;
        this.note = note;
        this.dateTime = dateTime;
    }
    public DateTimeException getDateTime(DateTimeException dateTime){
        return dateTime;
    }
    public void setDateTime(DateTimeException dateTime){
        this.dateTime = dateTime;
    }
    public Account getPreviousAccount(){
        return previousAccount;
    }
    public void setPreviousAccount(Account previousAccount){
        this.previousAccount = previousAccount;
    }
    public Account getNewAccount(){
        return newAccount;
    }
    public void setNewAccount(Account newAccount){
        this.newAccount = newAccount;
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

