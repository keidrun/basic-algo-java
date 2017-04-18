/**
 * Copyright 2017 Keid
*/
package stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Stack of LinkedList
 * 
 * @author Keid
 */
public class DynamicStack<E> implements Stack<E> {

    private transient List<E> list;

    public DynamicStack() {
        this.list = new LinkedList<E>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#push(java.lang.Object)
     */
    @Override
    public void push(E element) {
        list.add(element);
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#pop()
     */
    @Override
    public E pop() {
        return ((LinkedList<E>) list).removeLast();
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /* (non-Javadoc)
     * @see collection.Stack#size()
     */
    @Override
    public int size() {
        return list.size();
    }

}
