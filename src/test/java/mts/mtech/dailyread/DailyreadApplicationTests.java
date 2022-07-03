package mts.mtech.dailyread;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import mts.mtech.dailyread.utils.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DailyreadApplicationTests {
  private Sample sample;

  @BeforeEach
  void setUp() {
    sample = new Sample();
  }

  @Test
  public void testDivide(){
    assertEquals(10, sample.divide(100, 10));
  }

  @Test
  public void testException(){
    assertThrows(ArithmeticException.class, () -> sample.divide(10 , 0));
  }

  @Test
  public void testHello(){
    assertEquals("Hello World", sample.hello());
  }
}
