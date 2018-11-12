package strategy;

public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public SortingContext() {
        this.sortingStrategy = new MergeSort();
    }
    
    public int[] sort(int[] listToSort) {
        return sortingStrategy.sort(listToSort);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

}
