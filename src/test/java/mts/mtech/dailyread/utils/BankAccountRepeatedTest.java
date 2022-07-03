package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 6:38 PM
 */
@ExtendWith(BankAccountParamResolver.class)
public class BankAccountRepeatedTest {

  @RepeatedTest(3)
  @DisplayName("test successful withdrawal")
  void testDepositRepetition(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
    System.out.println("Number: " + repetitionInfo.getCurrentRepetition());
  }

}
