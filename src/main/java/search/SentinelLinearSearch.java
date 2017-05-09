/**
 * Copyright 2017 Keid
*/
package search;

import java.util.List;

/**
 * Sentinel Linear search
 * 
 * @author Keid
 */
public class SentinelLinearSearch implements Search<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see search.Search#search(java.lang.Object, java.util.List)
     */
    @Override
    public int search(Integer item, List<Integer> list) {

        // Set the sentinel.
        int size = list.size();
        int last = list.get(size - 1);
        list.set(size - 1, item);

        // Linear search.
        int searchedIndex = 0;
        while (list.get(searchedIndex) != item) {
            searchedIndex++;
        }

        list.set(size - 1, last);
        if (searchedIndex < size - 1) {
            return searchedIndex;
        } else if (item == last) {
            return searchedIndex;
        } else {
            return NOT_FOUND;
        }

    }

}
