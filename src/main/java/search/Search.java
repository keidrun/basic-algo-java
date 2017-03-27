/**
 * Copyright 2017 Keid
*/
package search;

import java.util.List;

/**
 * Search
 * 
 * @author Keid
 */
public interface Search<T> {

    /**
     * Search
     * 
     * @param item
     *            Searched item
     * @param list
     *            Data
     * @return Index of searched item
     */
    public int search(T item, List<T> list);

}
