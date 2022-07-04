package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/07/2022 - 10:27 PM
 */

public class BankAccountLifeCycleTest {
  static BankAccount bankAccount;

  @BeforeAll
  static void beforeAll() {
    System.out.println("Hi!!!");
    bankAccount = new BankAccount(500, 0);
  }

  @AfterAll
  static void afterAll() {
    System.out.println("Bye!!!");
  }

  @Test
  public void testWithdrawal(){
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }

  @Test
  public void testDeposit(){
    bankAccount.deposit(500);
    assertEquals(1000, bankAccount.getBalance());
  }
}
