/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Binary Insertion sort
 * 
 * @author Keid
 */
public class BinaryInsertionSort implements Sort<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see sort.Sort#sort(java.util.List)
     */
    @Override
    public void sort(List<Integer> list) {

        int num = list.size();
        for (int sortedNum = 1; sortedNum < num; ++sortedNum) {

            int insertItem = list.get(sortedNum);

            // binary search
            int insertIndex;
            int left = 0, right = sortedNum;
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < insertItem) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            insertIndex = left;

            // insert
            while (insertIndex <= sortedNum) {
                int temp = list.get(insertIndex);
                list.set(insertIndex, insertItem);
                insertItem = temp;
                ++insertIndex;
            }
        }
    }

}
