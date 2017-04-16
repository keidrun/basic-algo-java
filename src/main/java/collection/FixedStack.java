/**
 * Copyright 2017 Keid
*/
package collection;

import java.util.Arrays;

/**
 * Stack of Array
 * 
 * @author Keid
 */
public class FixedStack<E> implements Stack<E> {

    private transient Object[] stack;
    private transient int maxSize;
    private transient int top;

    public FixedStack(int size) {
        this.maxSize = size;
        this.stack = new Integer[maxSize];
        this.top = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#push(java.lang.Object)
     */
    @Override
    public void push(E element) {
        // stack overflow
        if (isFull()) {
            throw new IllegalStateException("The stack is full.");
        }
        stack[top++] = element;
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#pop()
     */
    @SuppressWarnings("unchecked")
    @Override
    public E pop() {
        // stack underflow
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty.");
        }
        return (E) stack[--top];
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * If the stack is full.
     * 
     * @return if the stack is full
     */
    public boolean isFull() {
        if (top == stack.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Resize the stack.
     * 
     * @param newSize
     *            new size of the stack
     */
    public void resize(int newSize) {
        if (top > newSize) {
            throw new IllegalStateException("Top: " + top + " > New Size: " + newSize);
        }
        maxSize = newSize;
        Object[] temp = Arrays.copyOf(stack, maxSize);
        stack = new Object[maxSize];
        System.arraycopy(temp, 0, stack, 0, maxSize);
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Stack#size()
     */
    @Override
    public int size() {
        return top;
    }

}
