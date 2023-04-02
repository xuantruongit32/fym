class Tranfer{
    private Account previousAccount; // Have account class
    private Account newAccount; // Have account class
    private double amount;
    private String note;

     Tranfer(Account previousAccount, Account newAccount, double amount, String note){
        this.previousAccount = previousAccount;
        this.newAccount = newAccount;
        this.amount = amount;
        this.note = note;
    }
    Account getPreviousAccount(){
        return previousAccount;
    }
    void setPreviousAccount(Account previousAccount){
        this.previousAccount = previousAccount;
    }
    Account getNewAccount(){
        return newAccount;
    }
    void setNewAccount(Account newAccount){
        this.newAccount = newAccount;
    }
    void setAmount(double amount){
        this.amount = amount;
    }
    double getAmount(){
        return amount;
    }
    void setNote(String note){
        this.note = note;
    }
    String getNote(){
        return note;
    }
    
}

