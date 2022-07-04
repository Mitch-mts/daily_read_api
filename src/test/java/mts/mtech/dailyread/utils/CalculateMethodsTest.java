package mts.mtech.dailyread.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    Mockito.when(methods.add(5,3)).thenReturn(8);
  }

  @Test
  void add() {
    assertEquals(8, methods.add(5,3));
  }
}