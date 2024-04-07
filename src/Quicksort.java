import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Yuxuan Li
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        quicksort(values, order, 0, values.length - 1);
    }

    private <T> void quicksort(T[] values, Comparator<? super T> order, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(values, order, low, high);

            quicksort(values, order, low, pivotIndex - 1); 
            quicksort(values, order, pivotIndex + 1, high); 
        }
    }

    private <T> int partition(T[] arr, Comparator<? super T> order, int low, int high) {
        // Choosing the rightmost element as the pivot
        T pivot = arr[high];
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (order.compare(arr[j], pivot) <= 0) {
                i++;

                // Swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partitioning index
    }
} // class Quicksort
