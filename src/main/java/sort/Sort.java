/**
 * Copyright 2017 Keid
*/
package sort;

import java.util.List;

/**
 * Sort interface
 * 
 * @author Keid
 */
public interface Sort {

    /**
     * Sort
     * 
     * @param list
     *            Not sorted data
     */
    public void sort(List<Integer> list);

    /**
     * Swipe A and B
     * 
     * @param indexA
     * @param indexB
     * @param list
     */
    default void swipe(int indexA, int indexB, List<Integer> list) {

        if (indexA < 0 || indexB < 0 || list.size() <= indexA || list.size() <= indexB) {
            throw new IllegalArgumentException("Bad arguments.");
        }

        int temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

}
