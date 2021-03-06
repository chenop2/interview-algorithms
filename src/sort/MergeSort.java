package sort;

import java.util.Arrays;

/**
 * Created by Chen on 10/03/2016.
 */
public class MergeSort {
    public static void main(String[] argv) {
        Integer[] array = SortUtils.createMockArray();

        SortUtils.printArray(mergeSort(array));
    }

    private static Integer[] mergeSort(Integer[] array) {
        int length = array.length;
        if (length <= 1)
            return array;

        Integer[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, length / 2 ));
        Integer[] rightArray = mergeSort(Arrays.copyOfRange(array, leftArray.length , length));

        return merge(leftArray, rightArray);
    }

    private static Integer[] merge(Integer[] leftArray, Integer[] rightArray) {
        Integer[] merged = new Integer[leftArray.length + rightArray.length];

        int l = 0, r = 0, j = 0;

        while ( l < leftArray.length || r < rightArray.length) {
            if (r >= rightArray.length) {
                merged[j] = leftArray[l];
                l++;
            }
            else if (l >= leftArray.length) {
                merged[j] = rightArray[r];
                r++;
            }
            else if (leftArray[l] < rightArray[r]) {
                merged[j] = leftArray[l];
                l++;
            }
            else {
                merged[j] = rightArray[r];
                r++;
            }
            j++;
        }

        return merged;
    }
}
