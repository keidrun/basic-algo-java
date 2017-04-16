/**
 * Copyright 2017 Keid
*/
package queue;

import java.util.Arrays;

/**
 * Queue of Array
 * 
 * @author Keid
 */
public class FixedQueue<E> implements Queue<E> {

    private transient Object[] ringBuffer;
    private transient int maxSize;
    private transient int first;
    private transient int last;

    public FixedQueue(int size) {
        this.maxSize = size + 1;
        this.ringBuffer = new Object[maxSize];
        this.first = this.last = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#enqueue(java.lang.Object)
     */
    @Override
    public void enqueue(E element) {
        // queue overflow
        if (isFull()) {
            throw new IllegalStateException("The queue is full.");
        }
        ringBuffer[last] = element;
        last = (last + 1) % maxSize;
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#dequeue()
     */
    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() {
        // queue underflow
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }
        E result = (E) ringBuffer[first];
        first = (first + 1) % maxSize;
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see collection.Queue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        if (first == last) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * If the queue is full.
     * 
     * @return if the queue is full
     */
    public boolean isFull() {
        if (first == (last + 1) % maxSize) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Resize the queue.
     * 
     * @param newSize
     *            new size of the queue
     */
    public void resize(int newSize) {
        int originSize = size();
        if (originSize > newSize) {
            throw new IllegalStateException("Origin Size: " + originSize + " > New Size: " + newSize);
        }
        maxSize = newSize + 1;
        Object[] temp = Arrays.copyOf(ringBuffer, maxSize);
        ringBuffer = new Object[maxSize];
        System.arraycopy(temp, 0, ringBuffer, 0, maxSize);
    }

    /* (non-Javadoc)
     * @see collection.Queue#size()
     */
    @Override
    public int size() {
        return last - first;
    }

}
