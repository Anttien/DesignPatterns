package strategy;

/**
 * A strategy that sorts with selection sort.
 *
 * The selection sort implementation is by Rajat Mishra and taken from
 * https://www.geeksforgeeks.org/selection-sort/ (12.11.2018)
 *
 * @author Antti Nieminen, Rajat Mishra
 */
public class SelectionSort implements SortingStrategy {

    @Override
    public int[] sort(int[] listToSort) {
        selectionSort(listToSort);
        return listToSort;
    }

    private void selectionSort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array 
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

}
