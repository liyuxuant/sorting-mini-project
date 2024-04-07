import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Your Name Here
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        mergeSort(values, 0, values.length, order);
    }

    private static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> order) {
        if (hi - lo < 2) { 
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(vals, lo, mid, order); // Sort the left half
        mergeSort(vals, mid, hi, order); // Sort the right half
        merge(vals, lo, mid, hi, order); // Merge the sorted halves
    }

    private static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> order) {
        // Create a temporary array for merging
        T[] temp = Arrays.copyOfRange(vals, lo, mid);
        int i = 0; 
        int j = mid; 
        int k = lo; 

        while (i < temp.length && j < hi) {
            if (order.compare(temp[i], vals[j]) <= 0) {
                vals[k++] = temp[i++];
            } else {
                vals[k++] = vals[j++];
            }
        }

        
        while (i < temp.length) {
            vals[k++] = temp[i++];
        }
        
    }
} // class MergeSort
