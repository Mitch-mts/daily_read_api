package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 6:04 PM
 */
// for ordering tests execution
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTest {
  static BankAccount bankAccount = new BankAccount(0, 0);

  @Test
  @Order(2)
  public void testWithdrawal(){
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }

  @Test
  @Order(1)
  public void testDeposit(){
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }

}
