/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Bubble sort
 * 
 * @author Keid
 */
public class BubbleSort implements Sort {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public List<Integer> sort(List<Integer> list) {
        boolean isSorted = false;
        int sortedNum = 0;

        do {
            isSorted = true;
            for (int i = 0; i < list.size() - 1 - sortedNum ; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    isSorted = false;
                    Integer temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
            sortedNum++;
        } while (!isSorted);

        return list;
    }

}
