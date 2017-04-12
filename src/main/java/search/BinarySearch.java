/**
 * Copyright 2017 Keid
*/
package search;

import java.util.List;

/**
 * Binary search.
 * 
 * @author Keid
 */
public class BinarySearch implements Search<Integer> {

    private static final int NOT_FOUND = -1;

    private static enum Pattern {
        LEFT, MID, RIGHT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see search.Search#search(java.lang.Object, java.util.List)
     */
    @Override
    public int search(Integer item, List<Integer> list) {
        // The list must be already sorted.
        return search(item, list, Pattern.MID);
    }

    private int search(Integer item, List<Integer> list, Pattern pattern) {

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            switch (pattern) {
            case MID:
                if (list.get(mid) == item) {
                    return mid;
                }
                if (list.get(mid) < item) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                break;
            case LEFT:
                if (list.get(mid) < item) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                if (list.get(left) == item) {
                    return left;
                }
                break;
            case RIGHT:
                if (list.get(mid) <= item) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
                if (list.get(right) == item) {
                    return right;
                }
                break;
            }

        }

        return NOT_FOUND;
    }

}
