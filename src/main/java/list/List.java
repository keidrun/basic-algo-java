/**
 * Copyright 2017 Keid
*/
package list;

/**
 * List
 * 
 * @author Keid
 */
public interface List<E> {

    /**
     * Add element after the last element.
     * 
     * @param element
     */
    public void add(E element);

    /**
     * Remove the element of the index.
     * 
     * @param index
     *            the index
     * @return the removed element
     */
    public E remove(int index);

    /**
     * Set the element to the index.
     * 
     * @param index
     *            the index
     * @param element
     *            the element
     */
    public void set(int index, E element);

    /**
     * Get element of index.
     * 
     * @param index
     *            the index
     * @return element
     */
    public E get(int index);

    /**
     * Get the size
     * 
     * @return the size
     */
    public int size();

}
