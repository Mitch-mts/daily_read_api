package mts.mtech.dailyread.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 4:21 PM
 */

class BankAccountTest {
  private BankAccount bankAccount;

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName("test successful withdrawal")
  void testWithdraw() {
    BankAccount bankAccount = new BankAccount(500, -1000);
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }

  @Test
  @DisplayName("test successful deposit")
  void testDeposit() {
    BankAccount bankAccount = new BankAccount(400, 0);
    bankAccount.deposit(500);
    //message is displayed if test fails
    assertEquals(900, bankAccount.getBalance(), "Unexpected Value provided");
  }

  @Test
  @DisplayName("test withdraw will become negative")
  public void testWidrawalNOtStuckAtZero(){
    BankAccount bankAccount = new BankAccount(500, -1000);
    bankAccount.withdraw(800);
    assertNotEquals(0, bankAccount.getBalance());
  }

  @Test
  @DisplayName("test if bank account is active")
  public void testActive(){
    BankAccount bankAccount = new BankAccount(500, 0);
    assertTrue(bankAccount.isActive());
  }

  @Test
  @DisplayName("test is holder name is null")
  public void testHolderNameSet(){
    BankAccount bankAccount = new BankAccount(500, 0);
    bankAccount.setHolderName("Mitch");
    assertNotNull(bankAccount.getHolderName());
  }

  @Test
  @DisplayName("test withdraw below min amount")
  public void testNoWithdrawBelowMinimum(){
    BankAccount bankAccount = new BankAccount(500, -1000);
    assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
  }

  @Test
  @DisplayName("test no exceptions are thrown for withdraw and deposit")
  public void testWithdrawAndDepositWithoutException(){
    BankAccount bankAccount = new BankAccount(500, -1000);
    assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
  }

  @Test
  public void testDepositTimeout(){
    BankAccount bankAccount =  new BankAccount(500, 0);
    assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(100));
  }

  @Test
//  @Disabled("Test temporarily disabled due to maintainance")
  public void testDisabled(){
    BankAccount bankAccount =  new BankAccount(500, 0);
    assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(100));
  }
}