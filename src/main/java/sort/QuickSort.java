/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Quick sort
 * 
 * @author Keid
 */
public class QuickSort implements Sort {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public void sort(List<Integer> list) {

        int bottom = 0;
        int top = list.size() - 1;

        quickSort(bottom, top, list);

    }

    /**
     * Quick Sort implementation
     * 
     * @param bottom
     *            Minimum of data
     * @param top
     *            Maximum of data
     * @param list
     *            Not Sorted data
     */
    private void quickSort(int bottom, int top, List<Integer> list) {

        // done if the size of a group equals 1.
        if (bottom >= top) {
            return;
        }

        int pivot = list.get(bottom);

        int lower, upper;
        for (lower = bottom, upper = top; lower < upper;) {
            while (lower <= upper && list.get(lower) <= pivot) {
                lower++;
            }
            while (lower <= upper && list.get(upper) > pivot) {
                upper--;
            }
            if (lower < upper) {
                swipe(lower, upper, list);
            }
        }

        swipe(bottom, upper, list);

        quickSort(bottom, upper - 1, list);
        quickSort(bottom + 1, top, list);
    }
}
