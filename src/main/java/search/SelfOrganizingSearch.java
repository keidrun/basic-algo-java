/**
 * Copyright 2017 Keid
*/
package search;

import java.util.LinkedList;
import java.util.List;

/**
 * Self-Organizing search
 * 
 * @author Keid
 */
public class SelfOrganizingSearch implements Search<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see search.Search#search(java.lang.Object, java.util.List)
     */
    @Override
    public int search(Integer item, List<Integer> list) {
        if (list instanceof LinkedList) {
            for (int searchedIndex = 0; searchedIndex < list.size(); searchedIndex++) {
                if (list.get(searchedIndex) == item) {

                    // move the searched value to the first of the list.
                    Integer searchedValue = list.remove(searchedIndex);
                    ((LinkedList<Integer>) list).addFirst(searchedValue);

                    return searchedIndex;
                }
            }
        } else {
            throw new IllegalArgumentException("List type must be 'LinkedList', List: " + list.getClass());
        }

        return NOT_FOUND;
    }

}
