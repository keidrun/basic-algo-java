/**
 * Copyright 2017 Keid
*/
package queue;

/**
 * Queue
 * 
 * @author Keid
 */
public interface Queue<E> {

    /**
     * Enqueue the element to queue.
     * 
     * @param element
     *            the element
     */
    public void enqueue(E element);

    /**
     * Dequeue the element from queue.
     * 
     * @return the element
     */
    public E dequeue();

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
