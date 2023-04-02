class Transaction{
    private String type; // Income, Expense, Transfer
    private Account account; // Have account class
    private String category;
    private double amount;
    private String note;

     Transaction(String type, Account account, String category, double amount, String note){
        this.type = type;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }
    void setType(String type){
        this.type = type;
    }
    String getType(){
        return type;
    }
    void setAccount(Account account){
        this.account = account;
    }
    Account getAccount(){
        return account;
    }
    void setCategory(String category){
        this.category = category;
    }
    String getCategory(){
        return category;
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
