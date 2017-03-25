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
public interface Sort <T> {

    /**
     * Sort
     * 
     * @param list
     *            Not sorted data
     */
    public void sort(List<T> list);

    /**
     * Swipe A and B
     * 
     * @param indexA
     * @param indexB
     * @param list
     */
    default void swipe(int indexA, int indexB, List<T> list) {

        if (indexA < 0 || indexB < 0 || list.size() <= indexA || list.size() <= indexB) {
            throw new IllegalArgumentException("Bad arguments.");
        }

        T temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

}
