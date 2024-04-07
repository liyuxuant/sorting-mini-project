import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Yuxuan Li
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void ascendingOrderTest() {
      String[] original = { "echo", "alpha", "delta", "bravo", "charlie" };
      String[] expected = { "alpha", "bravo", "charlie", "delta", "echo" };
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(expected, original);
  }

  @Test
  public void descendingOrderTest() {
      String[] original = { "alpha", "bravo", "charlie", "delta", "echo" };
      String[] expected = { "echo", "delta", "charlie", "bravo", "alpha" };
      sorter.sort(original, (x, y) -> y.compareTo(x));
      assertArrayEquals(expected, original);
  }

  @Test
  public void duplicatesTest() {
      String[] original = { "delta", "alpha", "echo", "alpha", "delta" };
      String[] expected = { "alpha", "alpha", "delta", "delta", "echo" };
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(expected, original);
  }

  @Test
  public void emptyStringsTest() {
      String[] original = { "bravo", "", "delta", "", "alpha" };
      String[] expected = { "", "", "alpha", "bravo", "delta" };
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(expected, original);
  }

  @Test
  public void allEqualElementsTest() {
      String[] original = { "alpha", "alpha", "alpha", "alpha", "alpha" };
      String[] expected = { "alpha", "alpha", "alpha", "alpha", "alpha" };
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(expected, original);
  }
} // class SortTester
