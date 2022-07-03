package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/07/2022 - 10:13 PM
 */
@ExtendWith(BankAccountParamResolver.class)
public class BankAccountTimeoutTest {

  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  public void testDepositTimeout(BankAccount bankAccount){
    try{
      Thread.sleep(300);
    }catch (InterruptedException e){
      e.printStackTrace();
    }

    bankAccount.deposit(300);
    assertEquals(300, bankAccount.getBalance());
  }

}
