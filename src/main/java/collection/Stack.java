/**
 * Copyright 2017 Keid
*/
package collection;

/**
 * Stack
 * 
 * @author Keid
 */
public interface Stack<E> {

    /**
     * Push the element to the stack.
     * 
     * @param element
     *            the element
     */
    public void push(E element);

    /**
     * Pop the element from the stack.
     * 
     * @return the element
     */
    public E pop();

    /**
     * If the stack is empty.
     * 
     * @return if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Get the size
     * 
     * @return the size
     */
    public int size();

}
