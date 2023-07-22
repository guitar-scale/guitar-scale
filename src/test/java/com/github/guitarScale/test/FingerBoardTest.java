package com.github.guitarScale.test;

import com.github.guitarScale.FingerBoard;
import com.github.guitarScale.KeyBase;
import com.github.guitarScale.ScaleBase;
import com.github.guitarScale.Tuning;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class FingerBoardTest {
  @Test
  public void case01() {
    FingerBoard fb = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning( // or Tuning.getStandardTuning();
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    int[][] expect = {
        {1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1},
        {2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2},
        {1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1},
        {1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
        {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1},
        {1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 1, 0, 1, 0, 1}
    };

    Assert.assertArrayEquals(fb.getStructure(), expect);
  }

  @Test
  public void case02() {
    FingerBoard fb = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Major,
        new Tuning( // or Tuning.getStandardTuning();
            new int[]{
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    String expectStr = "1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, \n" +
        "2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, \n" +
        "1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, \n" +
        "0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, \n" +
        "1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, \n" +
        "1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, \n";

    assertEquals(fb.toString(), expectStr);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfFretsLessThan12() {
    FingerBoard fb = new FingerBoard(
        10, // less than 12
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfFretsGreaterThan32() {
    FingerBoard fb = new FingerBoard(
        33, // greater than 32
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );
  }

  @Test
  public void testEqualsAndHashCode() {
    FingerBoard fb1 = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    FingerBoard fb2 = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    // Test equals

    assertTrue(fb1.equals(fb2));
    assertTrue(fb2.equals(fb1));

    // Test hashCode
    assertEquals(fb1.hashCode(), fb2.hashCode());
  }

  @Test
  public void testEquals() {
    FingerBoard fb1 = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    FingerBoard fb2 = new FingerBoard(
        24,
        KeyBase.A,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    FingerBoard fb3 = new FingerBoard(
        24,
        KeyBase.B,
        ScaleBase.Minor,
        new Tuning(
            new int[]{
                KeyBase.fromString("E").toInt(),
                KeyBase.fromString("A").toInt(),
                KeyBase.fromString("D").toInt(),
                KeyBase.fromString("G").toInt(),
                KeyBase.fromString("B").toInt(),
                KeyBase.fromString("E").toInt()
            }
        )
    );

    // Test equals with the same object
    assertTrue(fb1.equals(fb1));

    // Test equals with a different object but the same properties
    assertTrue(fb1.equals(fb2));

    // Test equals with a different object and different properties
    assertFalse(fb1.equals(fb3));

    // Test equals with null
    assertFalse(fb1.equals(null));

    // Test equals with a different class
    assertFalse(fb1.equals("a string"));
  }

}
