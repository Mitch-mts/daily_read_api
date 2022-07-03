package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 6:13 PM
 */

public class BankAccountNestedTest {

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
    assertEquals(900, bankAccount.getBalance());
  }

  @Nested
  class WhenBalanceEqualsZero{

    @Test
    @DisplayName("min 0 balance execution")
    public void testWithdrawMinBalanceIs0(){
      BankAccount bankAccount = new BankAccount(0, 0);
      assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
    }

    @Test
    @DisplayName("min -1000 balance execution")
    public void testWithdrawMinBalanceNeg1000(){
      BankAccount bankAccount = new BankAccount(0, -1000);
      bankAccount.withdraw(500);
      assertEquals(-500, bankAccount.getBalance());
    }
  }

}
