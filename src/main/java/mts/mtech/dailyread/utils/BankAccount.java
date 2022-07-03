package mts.mtech.dailyread.utils;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 4:15 PM
 */

public class BankAccount {
  private double balance;
  private double minBalance;
  private boolean isActive = true;
  private String holderName;

  public BankAccount(double balance, double minBalance){
    this.balance = balance;
    this.minBalance = minBalance;
  }

  public double getBalance(){
    return balance;
  }

  public double getMinBalance(){
    return  minBalance;
  }

  public boolean isActive() {
    return isActive;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public double withdraw(double amount){
    if(balance - amount > minBalance){
      balance -= amount;
      return amount;
    }else{
      throw new RuntimeException();
    }
  }

  public double deposit(double amount){
    return balance += amount;
  }

}
