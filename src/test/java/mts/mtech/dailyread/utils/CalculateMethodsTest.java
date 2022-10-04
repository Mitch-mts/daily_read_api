package mts.mtech.dailyread.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/07/2022 - 11:28 PM
 */
@ExtendWith(MockitoExtension.class)
class CalculateMethodsTest {
  @Mock
  CalculateMethods methods;

  @BeforeEach
  void setUp() {
    methods = new CalculateMethods();
  }

  @Test
  @DisplayName("should add two numbers")
  void add() {
    int expected = 8;
    int result = methods.add(5, 3);

    assertThat(expected).isEqualTo(result);
  }

  @Test
  @DisplayName("should subtract two numbers")
  void shouldSubtractTwoNumbers(){
    int expected = 5;
    int result = methods.subtract(10, 5);

    assertThat(expected).isEqualTo(result);
  }

}