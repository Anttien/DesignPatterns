package strategy;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] listToSort = new int[1000000];
        SortingContext sortingcontext = new SortingContext();

        for (int i = 0; i < listToSort.length; i++) {
            listToSort[i] = random.nextInt(10000000);
        }
        sortingcontext.setSortingStrategy(new MergeSort());
        sortAndTakeTime(sortingcontext, listToSort, "merge sort");
        sortingcontext.setSortingStrategy(new SelectionSort());
        sortAndTakeTime(sortingcontext, listToSort, "selection sort");
        sortingcontext.setSortingStrategy(new QuickSort());
        sortAndTakeTime(sortingcontext, listToSort, "quick sort");
    }

    public static void sortAndTakeTime(SortingContext sortingcontext, int[] listToSort, String sortingMethod) {
        long startingTime;
        long endingTime;
        startingTime = System.currentTimeMillis();
        sortingcontext.sort(listToSort);
        endingTime = System.currentTimeMillis();
        System.out.printf("Sorting done (%s)! Took: %.2f seconds. \n", sortingMethod, (double) (endingTime - startingTime) / 1000);
    }

}
