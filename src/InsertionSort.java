import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        for (int i = 1; i < values.length; i++) {
            T current = values[i];
            int j = i - 1;

            // Move elements of values[0..i-1], that are greater than current,
            // to one position ahead of their current position
            while (j >= 0 && order.compare(values[j], current) > 0) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = current;
        }
    }
  
} // class InsertionSort
