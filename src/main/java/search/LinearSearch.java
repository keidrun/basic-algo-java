/**
 * Copyright 2017 Keid
*/
package search;

import java.util.List;

/**
 * Liner search
 * 
 * @author Keid
 */
public class LinearSearch implements Search<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see search.Search#search(java.lang.Object, java.util.List)
     */
    @Override
    public int search(Integer item, List<Integer> list) {

        for (int searchedIndex = 0; searchedIndex < list.size(); searchedIndex++) {
            if (list.get(searchedIndex) == item) {
                return searchedIndex;
            }
        }

        return NOT_FOUND;
    }

}
