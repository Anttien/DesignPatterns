package strategy;

import java.util.Arrays;

/**
 * This strategy sorts the array by utilizing the
 * {@link java.util.Arrays#sort sort} method from java.util.Arrays
 *
 * @author Antti Nieminen
 */
public class QuickSort implements SortingStrategy {

    @Override
    public int[] sort(int[] listToSort) {
        Arrays.sort(listToSort);
        return listToSort;
    }

}
