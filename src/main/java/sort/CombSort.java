/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Comb sort
 * 
 * @author Keid
 */
public class CombSort implements Sort<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public void sort(List<Integer> list) {

        double shrinkFactor = 1.3;
        combSort(shrinkFactor, list);

    }

    /**
     * Comb sort implementation
     * 
     * @param shrinkFactor
     *            a shrink factor
     * @param list
     *            Not sorted data
     */
    private void combSort(double shrinkFactor, List<Integer> list) {

        boolean isSorted = false;
        int num = list.size();
        int gap = num;

        do {

            gap = (int) ((gap * 10) / (shrinkFactor * 10));

            if (gap == 0) {
                gap = 1;
            }

            isSorted = true;
            for (int i = 0; i < num - gap; ++i) {
                if (list.get(i) > list.get(i + gap)) {
                    isSorted = false;
                    swipe(i, i + gap, list);
                }
            }

            // done if a gap equals 1 and data is sorted.
        } while ((gap > 1) || !isSorted);
    }

}
