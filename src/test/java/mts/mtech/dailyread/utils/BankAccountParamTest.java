package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 8:50 PM
 */
@ExtendWith(BankAccountParamResolver.class)
public class BankAccountParamTest {

  @ParameterizedTest
  @ValueSource(ints = {100, 400, 800 , 1000})
  @DisplayName("depositing successfully")
  void testDepositValueSource(int amount, BankAccount bankAccount) {
    bankAccount.deposit(amount);
    assertEquals(amount, bankAccount.getBalance());
  }

  @ParameterizedTest
  @CsvFileSource(resources = "data.csv", delimiter = ';')
  public void testDepositAndName(double amount, String name, BankAccount bankAccount){
    bankAccount.deposit(amount);
    bankAccount.setHolderName(name);
    assertEquals(amount, bankAccount.getBalance());
    assertEquals(name, bankAccount.getHolderName());
  }

  @ParameterizedTest
  @EnumSource(value = DayOfWeek.class, names = { "TUESDAY", "THURSDAY"})
  public void testDayOfWeek(DayOfWeek day){
    assertTrue(day.toString().startsWith("T"));
  }
}
