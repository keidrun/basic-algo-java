/**
 * Copyright 2017 Keid
*/
package queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Queue of LinkedList
 * 
 * @author Keid
 */
public class DynamicQueue<E> implements Queue<E> {

    private transient List<E> list;

    public DynamicQueue() {
        list = new LinkedList<>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#enqueue(java.lang.Object)
     */
    @Override
    public void enqueue(E element) {
        list.add(element);
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#dequeue()
     */
    @Override
    public E dequeue() {
        return ((LinkedList<E>) list).removeFirst();
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /* (non-Javadoc)
     * @see collection.Queue#size()
     */
    @Override
    public int size() {
        return list.size();
    }

}
