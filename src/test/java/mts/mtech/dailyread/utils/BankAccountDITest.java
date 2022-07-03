package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 9:39 PM
 */
@ExtendWith(BankAccountParamResolver.class)
public class BankAccountDITest {

  @Test
  @DisplayName("deposit 400 successfully")
  public void testDeposit(BankAccount bankAccount){
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());

  }
}
