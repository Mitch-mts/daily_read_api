package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/07/2022 - 10:23 PM
 */
//used for running multiple tests at the same time
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParamResolver.class)
public class BankAccountParallelExecutionTest {

  @Test
  @DisplayName("test successful deposit1")
  void testDeposit1() {
    BankAccount bankAccount = new BankAccount(400, 0);
    bankAccount.deposit(500);
    assertEquals(900, bankAccount.getBalance());
  }


  @Test
  @DisplayName("test successful deposit2")
  void testDeposit2() {
    BankAccount bankAccount = new BankAccount(400, 0);
    bankAccount.deposit(500);
    assertEquals(900, bankAccount.getBalance());
  }


  @Test
  @DisplayName("test successful deposit3")
  void testDeposit3() {
    BankAccount bankAccount = new BankAccount(400, 0);
    bankAccount.deposit(500);
    assertEquals(900, bankAccount.getBalance());
  }


}
