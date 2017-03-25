/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge sort
 * 
 * @author Keid
 */
public class MergeSort implements Sort<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public void sort(List<Integer> list) {
        mergeSort(list.size(), list, 0);
    }

    private void mergeSort(int num, List<Integer> list, int offset) {

        if (num <= 1) {
            return;
        }

        // separate the first harf and the second harf
        int firstHarf = num / 2;
        mergeSort(firstHarf, list, offset);
        mergeSort(num - firstHarf, list, offset + firstHarf);

        // merge
        List<Integer> buffer = new ArrayList<Integer>();
        for (int i = 0; i < firstHarf; i++) {
            buffer.add(list.get(offset + i));
        }

        int i = 0, j = firstHarf, k = 0;
        while (i < firstHarf && j < num) {
            if (buffer.get(i) <= list.get(offset + j)) {
                list.set(offset + k++, buffer.get(i++));
            } else {
                list.set(offset + k++, list.get(offset + j++));
            }
        }
        while (i < firstHarf) {
            list.set(offset + k++, buffer.get(i++));
        }

    }

}
