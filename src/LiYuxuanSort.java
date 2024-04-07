/**
 * My own sorting inspired by timesort
 *
 * @author Yuxuan Li
 * Acknowledgment: Chatgpt
 */
import java.util.Arrays;
import java.util.Comparator;

public class LiYuxuanSort implements Sorter {

    private static final int MIN_MERGE = 32;

    public static Sorter SORTER = new LiYuxuanSort();

    LiYuxuanSort() {}

    @Override
    public <T> void sort(T[] array, Comparator<? super T> order) {
        int n = array.length;
        // Use Insertion Sort for small fragments
        for (int i = 0; i < n; i += MIN_MERGE) {
            insertionSort(array, i, Math.min(i + MIN_MERGE, n), order);
        }
        // Merge sorted fragments using Merge Sort
        for (int size = MIN_MERGE; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size;
                int right = Math.min(left + 2 * size, n);
                if (mid < right) {
                    merge(array, left, mid, right, order);
                }
            }
        }
    }

    private <T> void insertionSort(T[] array, int left, int right, Comparator<? super T> order) {
        for (int i = left + 1; i < right; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= left && order.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private <T> void merge(T[] array, int left, int mid, int right, Comparator<? super T> order) {
        T[] temp = Arrays.copyOfRange(array, left, mid);
        int i = 0, j = mid, k = left;
        while (i < temp.length && j < right) {
            if (order.compare(temp[i], array[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = array[j++];
            }
        }
        while (i < temp.length) {
            array[k++] = temp[i++];
        }
        // Elements from j to right are already in place
    }
}
  

