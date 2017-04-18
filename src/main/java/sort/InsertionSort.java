/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Insertion sort
 * 
 * @author Keid
 */
public class InsertionSort implements Sort<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public void sort(List<Integer> list) {

        int num = list.size();
        for (int sortedNum = 0; sortedNum < num - 1; ++sortedNum) {

            int insertItem = list.get(sortedNum + 1);

            // linear search
            int insertIndex;
            for (insertIndex = 0; insertIndex <= sortedNum; ++insertIndex) {
                if (list.get(insertIndex) > insertItem) {
                    break;
                }
            }

            // insert
            while (insertIndex <= sortedNum + 1) {
                int temp = list.get(insertIndex);
                list.set(insertIndex, insertItem);
                insertItem = temp;
                ++insertIndex;
            }

        }

    }

}
