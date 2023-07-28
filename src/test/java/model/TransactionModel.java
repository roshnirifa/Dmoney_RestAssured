package model;

public class TransactionModel {
    public String from_account;
    public String to_account;
    public double amount;

    public TransactionModel(){

    }

    public String from_account() {
        return from_account;
    }

    public TransactionModel setFrom_account(String from_account) {
        this.from_account = from_account;
        return this;
    }

    public String to_account() {
        return to_account;
    }

    public TransactionModel setTo_account(String to_account) {
        this.to_account = to_account;
        return this;
    }

    public double amount() {
        return amount;
    }

    public TransactionModel setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public TransactionModel(String from_account, String to_account, double amount){
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
    }

}
