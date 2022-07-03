package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 5:54 PM
 */

public class BankAccountAssumptionsTest {

  @Test
  @DisplayName("test activation account after creation")
  public void testActive(){
    BankAccount bankAccount = new BankAccount(500, 0);
    assumingThat(bankAccount  != null, ()-> assertTrue(bankAccount.isActive()));
  }

}
