package mts.mtech.dailyread.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/07/2022 - 10:49 PM
 */
// running tests based on conditions of system properties
public class BankAccountConditionalTests {

  @Test
  @EnabledOnOs({OS.MAC})
  public void testMac(){

  }

  @Test
  @EnabledOnOs({OS.WINDOWS})
  public void testWindows(){

  }

  @Test
  @EnabledOnOs({OS.LINUX})
  public void testLinux(){

  }

  @Test
  @EnabledOnJre({JRE.JAVA_11})
  public void testJRE(){

  }

  @Test
  @EnabledOnJre({JRE.JAVA_17})
  public void testJRE17(){

  }

}
